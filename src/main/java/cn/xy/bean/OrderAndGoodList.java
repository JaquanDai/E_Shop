package cn.xy.bean;

import java.util.List;

public class OrderAndGoodList {

    private Orders order;
    private List<OrderDetailAndGood> orderDetailAndGoodList;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public List<OrderDetailAndGood> getOrderDetailAndGoodList() {
        return orderDetailAndGoodList;
    }

    public void setOrderDetailAndGoodList(List<OrderDetailAndGood> orderDetailAndGoodList) {
        this.orderDetailAndGoodList = orderDetailAndGoodList;
    }
}
