package cn.xy.service;

import cn.xy.bean.GoodsType;
import cn.xy.bean.OperatorOrderDetails;

import java.util.List;
import java.util.Map;

public interface OperatorService {

    Map operatorLogin(String operatorAccount, String pwd);

    List<OperatorOrderDetails> getOrderDetailsByOperator(int operatorId);

    List<GoodsType> getGoodsTypeByOperator(int operatorId);

}
