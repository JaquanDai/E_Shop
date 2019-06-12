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

    @Override
    public List<GoodsType> getOtherType(int operator_id) {
        return typeDao.getOtherType(operator_id);
    }

    @Override
    public void delOperatorGoodsType(int operator_id, int type_id) {
        typeDao.delOperatorGoodsType(operator_id,type_id);
    }

    @Override
    public void addOperatorGoodsType(int operator_id, List<Integer> type_id) {
        for(int i = 0;i<type_id.size();i++){
            typeDao.addOperatorGoodsType(operator_id,type_id.get(i));
        }

    }
}
