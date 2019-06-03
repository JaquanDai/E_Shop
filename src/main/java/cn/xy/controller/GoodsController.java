package cn.xy.controller;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsByType;
import cn.xy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/listGoodsByTypeId")
    @ResponseBody
    public List<Goods> listGoodsByTypeId(@RequestBody(required=true) Map<String,Object> map){
        List<Goods> goods=new ArrayList<>();
        goods = goodsService.getGoodsByType((Integer) map.get("type_id"));
        return goods;
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public Goods addGoods(@RequestBody(required=true) Map<String,Object> map){
        Goods goods = new Goods();
        goods.setType_id((Integer) map.get("type_id"));
        goods.setGoods_name((String) map.get("goods_name"));
        goods.setInventory(Integer.parseInt((String) map.get("inventory")));
        goods.setPrice(Float.parseFloat((String) map.get("price")) );
        goods.setDescription((String) map.get("describe"));
        goods.setGoods_status("active");
        goodsService.addGoods(goods);
        return goods;
    }

    @RequestMapping("/modifyGoods")
    @ResponseBody
    public Goods modifyGoods(@RequestBody(required=true) Map<String,Object> map){
        Goods goods = new Goods();
        goods.setType_id((Integer) map.get("type_id"));
        goods.setGoods_id((Integer) map.get("goods_id"));
        goods.setGoods_name((String) map.get("goods_name"));
        goods.setInventory(Integer.parseInt((String) map.get("inventory")));
        goods.setPrice(Float.parseFloat((String)map.get("price")));
        goods.setDescription((String) map.get("describe"));
        goods.setGoods_status("active");
        goodsService.modifyGoods(goods);
        return goods;
    }

    @RequestMapping("/deleteGoods")
    @ResponseBody
    public void deleteGoods(@RequestBody(required=true) Map<String,Object> map){
        goodsService.deleteGoods((Integer) map.get("goods_id"));
    }



}

