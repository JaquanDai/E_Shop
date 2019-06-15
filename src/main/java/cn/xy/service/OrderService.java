package cn.xy.service;

import cn.xy.bean.OrderAndGoodList;
import cn.xy.bean.OrderList;
import cn.xy.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface OrderService {
    Map<String,Integer> bought(int goods_id,int user_id);

    void modifyStatus(int od_id,String details_status);

    void deleteDetails(int od_id);

    List<OrderAndGoodList> getOrderListByDetailStatus(int user_id, String detail_status);

    List<OrderAndGoodList> getHistoryOrders(int user_id);

}
