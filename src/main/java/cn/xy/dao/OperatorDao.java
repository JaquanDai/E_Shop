package cn.xy.dao;

import cn.xy.bean.Operator;
import cn.xy.bean.OperatorOrderDetails;

import java.util.List;

public interface OperatorDao {

    //查找用户
    Operator getOperatorByAccount(String operatorAccount);
    //删除用户
    void delOperator(int operatorId);
    //搜索此管理员的订单
    List<OperatorOrderDetails> getOrderdetailsByOperator(int operatorId);
    //查询此管理员管理的商品类别
    List<Integer> getTypeIdByOperator(int operatorId);
    //查询此管理员管理的商品
    List<>

}
