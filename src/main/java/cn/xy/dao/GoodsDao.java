package cn.xy.dao;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsType;

import java.util.List;

public interface GoodsDao {
    List<Goods> getAllGoodsList();
    Goods getGoodsById(int goodsId);
    List<Goods> getGoodsByType(int TypeId);
    void addGoods(Goods goods);
    void modifyGoods(Goods goods);
    void deleteGoods(int goods_id);

}
