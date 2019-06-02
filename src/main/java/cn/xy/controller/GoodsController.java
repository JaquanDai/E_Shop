package cn.xy.controller;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsByType;
import cn.xy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/shop")
    @ResponseBody
    public List<GoodsByType> getAllGoodsList(){
        List<GoodsByType> goodsTypeList = goodsService.getAllGoodsList();
        return goodsTypeList;
    }

    @RequestMapping("/detail/{goodsId}")
    @ResponseBody
    public Goods getGoodsById(@PathVariable("goodsId") int goodsId){
        Goods goods=new Goods();
        goods = goodsService.getGoodsById(goodsId);
        return goods;
    }
}

