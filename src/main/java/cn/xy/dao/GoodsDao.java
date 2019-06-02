package cn.xy.dao;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsType;

import java.util.List;

public interface GoodsDao {
    public List<Goods> getAllGoodsList();
    public Goods getGoodsById(int goodsId);
}
