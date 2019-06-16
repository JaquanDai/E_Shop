package cn.xy.service.impl;


import cn.xy.bean.*;
import cn.xy.dao.CommentsDao;
import cn.xy.dao.GoodsDao;
import cn.xy.dao.OperatorDao;
import cn.xy.dao.TypeDao;
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
    @Autowired
    private GoodsDao goodsDao;


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

    @Override
    public Map<String, Integer> addOperator(String operator_account, String operator_pwd) {
        Map<String,Integer> result = new HashMap<>();
        if(operatorDao.getOperatorByAccount(operator_account)==null) {
            result.put("code", 1);
            operatorDao.addOperator(operator_account, operator_pwd);
        }else {
            result.put("code",-1);
        }

        return result;

    }

    @Override
    public List<Operator> getOperatorByType(int type_id) {
        return operatorDao.getOperatorByType(type_id);
    }

    @Override
    public Map<String, Integer> modifyOperatorPwd(int operator_id, String newPwd,String oldPwd) {

        Map<String,Integer> result = new HashMap<>();

        if(!operatorDao.getPwdByOperatorId(operator_id).equals(oldPwd)){
            result.put("code",-1);
        }else{
            result.put("code",1);
            operatorDao.modifyOperatorPwd(operator_id,newPwd);
        }
        return result;

    }

//    @Override
//    public List<CommentsReply> getCommentByOperator(int operator_id) {
//
//        List<GoodsType> goodsTypes = typeDao.getTypeByOperatorId(operator_id);
//        List<CommentsReply> commentsReplies = new ArrayList<>();
//        for (int i = 0;i<goodsTypes.size();i++){
//            List<Goods> goods = goodsDao.getGoodsByType(goodsTypes.get(i).getType_id());
//            for(int j=0;j<goods.size();j++){
//                commentsReplies.addAll(commentsDao.getGoodsComments(goods.get(j).getGoods_id()));
//            }
//        }
//
//        return commentsReplies;
//    }

    public List<Goods> getGoodsByType(int TypeId) { return goodsDao.getGoodsByType(TypeId); }


}
