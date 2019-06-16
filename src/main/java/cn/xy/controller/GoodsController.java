package cn.xy.controller;

import cn.xy.bean.Goods;
import cn.xy.bean.GoodsByType;
import cn.xy.bean.Result;
import cn.xy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @RequestMapping("/likeGoods/{goodsId}")
    @ResponseBody
    public  List<Goods> getSameGoodsList(@PathVariable("goodsId") int goodsId){
        return goodsService.getSameGoodsList(goodsId);

    }

    @RequestMapping("/searchGoods")
    @ResponseBody
    public List<Goods> searchGoods(@RequestBody(required=true) Map<String,Object> map){
        List<Goods> goods=new ArrayList<>();
        goods = goodsService.getSearchGoodsList((String) map.get("name"));
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
        goods.setGoods_img("/api/images/"+ map.get("goods_img"));
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
        goods.setSales(Integer.parseInt((String)map.get("sales")));
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

    /**
     * 文件上传
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping(value ="/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {

        //获取文件在服务器的储存位置
        //String path = "api";
        String path = request.getSession().getServletContext().getRealPath("")+"images";
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);

        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返回
            return new Result(true, fileName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }

}

