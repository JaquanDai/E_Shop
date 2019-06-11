package cn.xy.service.impl;

import cn.xy.dao.OrderDao;
import cn.xy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
