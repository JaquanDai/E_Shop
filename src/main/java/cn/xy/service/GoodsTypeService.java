package cn.xy.service;

import cn.xy.bean.GoodsType;

import java.util.List;

public interface GoodsTypeService {

    void addGoodsType(String type_name);

    List<GoodsType> getTypeByOperatorId(int operator_id);

}
