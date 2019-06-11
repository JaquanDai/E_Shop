package cn.xy.service;

import cn.xy.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface OrderService {

    void modifyStatus(int od_id,String details_status);

    void deleteDetails(int od_id);





}
