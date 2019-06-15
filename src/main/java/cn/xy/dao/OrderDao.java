package cn.xy.dao;

import cn.xy.bean.Cart;
import cn.xy.bean.OrderDetailAndGood;
import cn.xy.bean.Orders;
import cn.xy.bean.OrderDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    public void addCart(Orders order);
    public void addCartDetail(OrderDetails details);
    public void addOrder(Orders order);
    public void addOrderDetail(OrderDetails details);
    public void cart2order(Orders order);
    public void cart2detail(OrderDetails details);
    public void updateCartQuantity(OrderDetails details);
    public Orders searchCartByUser(int user_id);
    public List<OrderDetails> getAllCartDetails(int order_id);
    public OrderDetails getCartDetails(int od_id);
    public void deleteCartDetails(int od_id);
    public List<Cart> getCart(int order_id);
    public void buy(int od_id);
    public List<OrderDetails> bought(@Param("goods_id")int goods_id,@Param("user_id")int user_id);
    public void modifyStatus(@Param("od_id") int od_id, @Param("details_status")String details_status);
    public void deleteDetails(int od_id);

    //根据状态获得用户订单
    List<Orders> getOrdersByStatus(@Param("user_id")int user_id, @Param("details_status") String details_status);

    //得到用户订单详情
    List<OrderDetailAndGood> getOrderDetails(int order_id);

    //得到已完成的历史的订单
    List<Orders> getHistoryOrders(int order_id);
}
