package cn.xy.service;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsByType;
import cn.xy.bean.GoodsType;

import java.util.List;

public interface GoodsService {
    public List<GoodsByType> getAllGoodsList();
    public List<Goods> getSearchGoodsList(String name);
    public List<Goods> getSameGoodsList(int goods_id);
    public Goods getGoodsById(int goodsId);
    List<Goods> getGoodsByType(int TypeId);
    void addGoods(Goods goods);
    void modifyGoods(Goods goods);
    void deleteGoods(int goods_id);
}
