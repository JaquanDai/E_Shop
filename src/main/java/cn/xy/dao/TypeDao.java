package cn.xy.dao;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeDao {

    public String getTypeName(int typeId);

    void addGoodsType(String type_name);

    List<GoodsType> getTypeByOperatorId(int operator_id);

    List<GoodsType> getOtherType(int operator_id);

    void delOperatorGoodsType(@Param("operator_id") int operator_id,@Param("type_id") int type_id);

    void addOperatorGoodsType(@Param("operator_id") int operator_id,@Param("type_id") int type_id);
    //获得所有类型
    List<GoodsType> getAllType();
    //删除
    void deleteType(int type_id);
    //根据类型删除商品
    void deleteGoodsByType(int type_id);

}
