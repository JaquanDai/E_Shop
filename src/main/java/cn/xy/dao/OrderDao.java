package cn.xy.dao;

import cn.xy.bean.Cart;
import cn.xy.bean.Orders;
import cn.xy.bean.OrderDetails;

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
}
