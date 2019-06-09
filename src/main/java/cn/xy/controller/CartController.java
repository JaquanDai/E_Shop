package cn.xy.controller;

import cn.xy.bean.Cart;
import cn.xy.bean.OrderDetails;
import cn.xy.bean.OrderList;
import cn.xy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    @ResponseBody
    public List<OrderDetails> addCart(@RequestBody(required=true)OrderDetails details){
        return cartService.addCart(details);
    }

    @RequestMapping(value = "/getCart",method = RequestMethod.POST)
    @ResponseBody
    public List<Cart> getCart(@RequestBody(required=true)Map<String,Integer> map){
        int user_id = (int)map.get("user_id");
        List<Cart> carts = cartService.getCart(user_id);
        return carts;
    }

    @RequestMapping(value = "/updateCart",method = RequestMethod.POST)
    @ResponseBody
    public List<Cart> updateCart(@RequestBody(required=true)List<Cart> carts){
        return cartService.updateCart(carts);
    }

    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    @ResponseBody
    public OrderList buy(@RequestBody(required=true)OrderList orderList){
        return cartService.buy(orderList);
    }
}
