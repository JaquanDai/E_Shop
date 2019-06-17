package cn.xy.service;

import cn.xy.bean.Cart;
import cn.xy.bean.OrderDetails;
import cn.xy.bean.OrderList;

import java.util.List;

public interface CartService {
    public List<OrderDetails> addCart(OrderDetails details);
    public List<Cart> getCart(int order_id);
    public List<Cart> updateCart(List<Cart> carts,int userId);
    public OrderList buy(OrderList orderList);
}
