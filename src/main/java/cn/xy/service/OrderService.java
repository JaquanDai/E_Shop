package cn.xy.service;

import cn.xy.bean.OrderAndGoodList;
import cn.xy.bean.OrderList;
import cn.xy.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface OrderService {

    void modifyStatus(int od_id,String details_status);

    void deleteDetails(int od_id);

    List<OrderAndGoodList> getOrderListByDetailStatus(int user_id, String detail_status);

    List<OrderAndGoodList> getHistoryOrders(int user_id);

}
