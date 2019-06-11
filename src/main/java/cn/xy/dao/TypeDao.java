package cn.xy.dao;

import cn.xy.bean.GoodsType;

import java.util.List;

public interface TypeDao {
    public String getTypeName(int typeId);

    void addGoodsType(String type_name);

    List<GoodsType> getTypeByOperatorId(int operator_id);
}
