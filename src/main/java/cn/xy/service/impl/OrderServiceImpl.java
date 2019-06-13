package cn.xy.service.impl;

import cn.xy.bean.*;
import cn.xy.dao.OrderDao;
import cn.xy.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void modifyStatus(int od_id, String details_status) {
        orderDao.modifyStatus(od_id,details_status);
    }

    @Override
    public void deleteDetails(int od_id) {
        orderDao.deleteDetails(od_id);
    }

    @Override
    public List<OrderAndGoodList> getOrderListByDetailStatus(int user_id, String detail_status) {
        List<OrderAndGoodList> orderLists = new ArrayList<>();
        List<Orders> orders= orderDao.getOrdersByStatus(user_id, detail_status);
        for (Orders order:orders){
            OrderAndGoodList orderAndGoodList = new OrderAndGoodList();
            orderAndGoodList.setOrder(order);
            List<OrderDetailAndGood> orderDetails = orderDao.getOrderDetails(order.getOrder_id());
            orderAndGoodList.setOrderDetailAndGoodList(orderDetails);
            orderLists.add(orderAndGoodList);
        }
        return orderLists;
    }

    @Override
    public List<OrderAndGoodList> getHistoryOrders(int user_id) {
        List<OrderAndGoodList> orderLists = new ArrayList<>();
        List<Orders> orders= orderDao.getHistoryOrders(user_id);
        for (Orders order:orders){
            OrderAndGoodList orderAndGoodList = new OrderAndGoodList();
            orderAndGoodList.setOrder(order);
            List<OrderDetailAndGood> orderDetails = orderDao.getOrderDetails(order.getOrder_id());
            orderAndGoodList.setOrderDetailAndGoodList(orderDetails);
            orderLists.add(orderAndGoodList);
        }
        return orderLists;
    }

}
