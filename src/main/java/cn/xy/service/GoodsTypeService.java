package cn.xy.service;

import cn.xy.bean.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    //添加商品
    void addGoodsType(String type_name);

    List<GoodsType> getTypeByOperatorId(int operator_id);

    List<GoodsType> getOtherType(int operator_id);

    void delOperatorGoodsType(int operator_id,int type_id);

    void addOperatorGoodsType(int operator_id,List<Integer> type_id);
    //获得所有商品类别
    List<GoodsType> getAllType();
    //删除类别
    void deleteType(int type_id);
    //根据类型删除商品
    void deleteGoodsByType(int type_id);
}
