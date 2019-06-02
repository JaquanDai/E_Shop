package cn.xy.service;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsByType;
import cn.xy.bean.GoodsType;

import java.util.List;

public interface GoodsService {
    public List<GoodsByType> getAllGoodsList();
    public Goods getGoodsById(int goodsId);
}
