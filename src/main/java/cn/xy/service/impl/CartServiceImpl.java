package cn.xy.service.impl;

import cn.xy.bean.*;
import cn.xy.dao.GoodsDao;
import cn.xy.dao.OrderDao;
import cn.xy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GoodsDao goodsDao;

    public List<OrderDetails> addCart(OrderDetails details) {
        int user_id=details.getUser_id();
        //System.out.println("user_id----------------"+user_id);
        Orders cart = orderDao.searchCartByUser(user_id);

        if(cart == null){
            cart =new Orders();
            cart.setOrder_status("未付款");
            cart.setUser_id(user_id);
            orderDao.addCart(cart);
        }
        details.setOrder_id(cart.getOrder_id());
        List<OrderDetails> detailList = orderDao.getAllCartDetails(cart.getOrder_id());
        int flag = 0;
        for(OrderDetails od : detailList){
            if(od.getGoods_id()==details.getGoods_id()){
                int quantity=od.getQuantity()+details.getQuantity();
                od.setQuantity(quantity);
                orderDao.updateCartQuantity(od);
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            orderDao.addCartDetail(details);
        detailList = orderDao.getAllCartDetails(cart.getOrder_id());
        return detailList;
    }

    public List<Cart> getCart(int user_id) {
        //System.out.println(user_id+"------------------------------------");
        List<Cart> list = new ArrayList<>();
        Orders orders = orderDao.searchCartByUser(user_id);
        if(orders==null){
            //System.out.println("null!!!!");
            return list;
        }
        int order_id = orders.getOrder_id();

        list = orderDao.getCart(order_id);
        return list;


    }

    public List<Cart> updateCart(List<Cart> carts){
        int oid = carts.get(0).getOd_id();
        OrderDetails details = orderDao.getCartDetails(oid);
        int order_id = details.getOrder_id();
        List<OrderDetails> list = orderDao.getAllCartDetails(order_id);
        int f = 0;
        if(list.size()!=carts.size()){
            for(int i = 0;i<list.size();i++){
                f = 0;
                for(int j = 0;j<carts.size();j++){
                    if(list.get(i).getOd_id()==carts.get(j).getOd_id()){
                        f = 1;
                        break;
                    }
                }
                if(f==0){
                    orderDao.deleteCartDetails(list.get(i).getOd_id());
                }
            }
        }

        for(Cart cart:carts){
            int id= cart.getOd_id();
            int quantity = cart.getQuantity();
            OrderDetails orderDetails = orderDao.getCartDetails(id);
            orderDetails.setQuantity(quantity);
            orderDao.updateCartQuantity(orderDetails);
        }

        return carts;
    }

    public OrderList buy(OrderList orderList){
        List<Cart> carts = orderList.getCartList();
        int od_id = carts.get(0).getOd_id();
        int order_id = orderDao.getCartDetails(od_id).getOrder_id();
        List<OrderDetails> list = orderDao.getAllCartDetails(order_id);
        Orders order = orderList.getOrder();
        if(list.size()!=carts.size()){
            orderDao.addOrder(order);
            for(Cart cart:carts){
                int id=cart.getOd_id();
                OrderDetails details = orderDao.getCartDetails(id);
                //System.out.println(details.getGoods_id()+"-----------------------"+cart.getQuantity());
                goodsDao.buy(details.getGoods_id(),cart.getQuantity());
                details.setOrder_id(order.getOrder_id());
                details.setDetails_price(cart.getTotal());
                details.setQuantity(cart.getQuantity());
                details.setDetails_status("已付款");
                orderDao.addOrderDetail(details);
                orderDao.deleteCartDetails(id);

            }
        }else{
            order.setOrder_id(order_id);
            orderDao.cart2order(order);
            for(Cart cart:carts){
                int id=cart.getOd_id();
                OrderDetails details = orderDao.getCartDetails(id);
                goodsDao.buy(details.getGoods_id(),cart.getQuantity());
                details.setQuantity(cart.getQuantity());
                details.setDetails_status("已付款");
                details.setDetails_price(cart.getTotal());
                orderDao.cart2detail(details);
            }
        }

        return orderList;
    }
}
