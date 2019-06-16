package cn.xy.dao;

import cn.xy.bean.GoodsType;
import cn.xy.bean.Operator;
import cn.xy.bean.OperatorComments;
import cn.xy.bean.OperatorOrderDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    List<GoodsType> getTypeByOperator(int type_id);
    //获得普通管理员
    List<Operator> getNormalOperator();
    //添加管理员
    void addOperator(@Param("operator_account") String operator_account,@Param("operator_pwd") String operator_pwd);

    List<Operator> getOperatorByType(int type_id);
    //修改密码
    void modifyOperatorPwd(@Param("operator_id")int operator_id,@Param("newPwd")String newPwd);
    //获取密码
    String getPwdByOperatorId(int operator_id);
    //获得评论
    List<OperatorComments> getCommentByOperator(int operator_id);
}
