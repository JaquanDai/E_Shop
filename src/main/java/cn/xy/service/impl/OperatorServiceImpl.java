package cn.xy.service.impl;


import cn.xy.bean.GoodsType;
import cn.xy.bean.Operator;
import cn.xy.bean.OperatorOrderDetails;
import cn.xy.dao.OperatorDao;
import cn.xy.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    public Map operatorLogin(String operatorAccount,String pwd) {
        Map<String,Object> map = new HashMap<>();
        Operator operator = operatorDao.getOperatorByAccount(operatorAccount);
        System.out.println(operator.getOperator_pwd());
        System.out.println(pwd);
        if(operator == null||!pwd.equals(operator.getOperator_pwd())){
            map.put("code", -1);
        }
        else if(operator.getOperator_type().equals("super")){
            map.put("code",1);
            map.put("account",operator.getOperator_account());
            map.put("operatorId",operator.getOperator_id());
        }
        else {
            map.put("code", 0);
            map.put("account",operator.getOperator_account());
            map.put("operatorId",operator.getOperator_id());
        }
        return map;
    }

    public List<OperatorOrderDetails> getOrderDetailsByOperator(int operatorId){
        List<OperatorOrderDetails> result = new ArrayList<>();
        List<Integer> typelist = new ArrayList<>();
        typelist = operatorDao.getTypeIdByOperator(operatorId);
        for(int i=0;i<typelist.size();i++){
            result.addAll(operatorDao.getOrderdetailsByOperator(typelist.get(i)));
        }

        return result;
    }

    @Override
    public List<GoodsType> getGoodsTypeByOperator(int operatorId) {

        List<GoodsType> result = new ArrayList<>();
        List<Integer> typelist = new ArrayList<>();
        typelist = operatorDao.getTypeIdByOperator(operatorId);
        for(int i=0;i<typelist.size();i++){
            result.addAll(operatorDao.getTypeByOperator(typelist.get(i)));
        }

        return result;

    }

    @Override
    public List<Operator> getNormalOperator() {
        return operatorDao.getNormalOperator();
    }


}
