package cn.xy.service;

import cn.xy.bean.GoodsType;

import java.util.List;

public interface GoodsTypeService {

    void addGoodsType(String type_name);

    List<GoodsType> getTypeByOperatorId(int operator_id);

    List<GoodsType> getOtherType(int operator_id);

    void delOperatorGoodsType(int operator_id,int type_id);

    void addOperatorGoodsType(int operator_id,List<Integer> type_id);
}
