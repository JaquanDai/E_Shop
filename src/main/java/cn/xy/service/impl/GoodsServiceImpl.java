package cn.xy.service.impl;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsByType;
import cn.xy.bean.GoodsType;
import cn.xy.dao.GoodsDao;
import cn.xy.dao.TypeDao;
import cn.xy.dao.UserDao;
import cn.xy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private TypeDao typeDao;

    public List<GoodsByType> getAllGoodsList() {
        List<Goods> goodsList = goodsDao.getAllGoodsList();
        List<GoodsByType> goodsTypeList = new ArrayList<GoodsByType>();
        if(goodsList!=null){
            List<Goods> list = new ArrayList<Goods>();
            list.add(goodsList.get(0));
            for(int i=1;i<goodsList.size();i++){
                if(goodsList.get(i).getType_id() == goodsList.get(i-1).getType_id()){
                    list.add(goodsList.get(i));
                }else{
                    GoodsByType goodsByType = new GoodsByType();
                    goodsByType.setList(list);
                    String typeName = typeDao.getTypeName(list.get(0).getType_id());
                    goodsByType.setType(typeName);
                    goodsTypeList.add(goodsByType);
                    list = new ArrayList<Goods>();
                    list.add(goodsList.get(i));
                }
                if(i == goodsList.size()-1){
                    GoodsByType goodsByType = new GoodsByType();
                    goodsByType.setList(list);
                    String typeName = typeDao.getTypeName(list.get(0).getType_id());
                    goodsByType.setType(typeName);
                    goodsTypeList.add(goodsByType);
                }
            }
        }
        return goodsTypeList;
    }

    public List<Goods> getSearchGoodsList(String name){
        name = "%"+name+"%";
        List<Goods> goodsList = goodsDao.getSearchGoodsList(name);
        return goodsList;
    }

    public List<Goods> getSameGoodsList(int goods_id){
        List<Goods> goodsList = goodsDao.getSameGoodsList(goods_id);
        return goodsList;
    }

    public Goods getGoodsById(int goodsId) {
        return goodsDao.getGoodsById(goodsId);
    }

    @Override
    public List<Goods> getGoodsByType(int TypeId) { return goodsDao.getGoodsByType(TypeId); }

    @Override
    public void addGoods(Goods goods) { goodsDao.addGoods(goods); }

    @Override
    public void modifyGoods(Goods goods) { goodsDao.modifyGoods(goods); }

    @Override
    public void deleteGoods(int goods_id) { goodsDao.deleteGoods(goods_id);}
}
