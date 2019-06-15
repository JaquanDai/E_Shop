package cn.xy.service;

import cn.xy.bean.GoodsType;
import cn.xy.bean.Operator;
import cn.xy.bean.OperatorOrderDetails;

import java.util.List;
import java.util.Map;

public interface OperatorService {

    Map operatorLogin(String operatorAccount, String pwd);

    List<OperatorOrderDetails> getOrderDetailsByOperator(int operatorId);

    List<GoodsType> getGoodsTypeByOperator(int operatorId);

    List<Operator> getNormalOperator();

    Map<String,Integer> addOperator(String operator_account,String operator_pwd);
    //获得管理该
    List<Operator> getOperatorByType(int type_id);

}
