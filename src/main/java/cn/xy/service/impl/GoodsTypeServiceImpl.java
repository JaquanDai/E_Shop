package cn.xy.service.impl;

import cn.xy.bean.GoodsType;
import cn.xy.dao.TypeDao;
import cn.xy.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public void addGoodsType(String type_name) { typeDao.addGoodsType(type_name);}

    @Override
    public List<GoodsType> getTypeByOperatorId(int operator_id) {
        return typeDao.getTypeByOperatorId(operator_id);
    }
}
