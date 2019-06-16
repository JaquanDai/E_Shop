package cn.xy.dao;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
    public List<Goods> getAllGoodsList();
    public List<Goods> getSameGoodsList(int goods_id);
    public Goods getGoodsById(int goodsId);
    List<Goods> getGoodsByType(int TypeId);
    void addGoods(Goods goods);
    void modifyGoods(Goods goods);
    void deleteGoods(int goods_id);

    public void buy(@Param("goods_id")int goods_id,@Param("quantity") int quantity);
}
