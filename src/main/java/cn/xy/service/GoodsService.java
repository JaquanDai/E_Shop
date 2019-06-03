package cn.xy.service;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsByType;
import cn.xy.bean.GoodsType;

import java.util.List;

public interface GoodsService {
    List<GoodsByType> getAllGoodsList();
    Goods getGoodsById(int goodsId);
    List<Goods> getGoodsByType(int TypeId);
    void addGoods(Goods goods);
    void modifyGoods(Goods goods);
    void deleteGoods(int goods_id);

}
