package cn.xy.bean;

import java.util.List;

//[{"list":
// [{"goods_id":1,"type_id":1,"goods_name":"电子商品1","inventory":100,"description":"haha","price":200.0,"goods_img":"www","goods_status":"hao","sales":100,avgstar:5},
// {"goods_id":2,"type_id":1,"goods_name":"电子商品2","inventory":100,"description":"haha","price":200.0,"goods_img":"www","goods_status":"hao","sales":100,avgstar:5}],
// "type":"电子商品"},
// {"list":
// [{"goods_id":3,"type_id":2,"goods_name":"饮料零食1","inventory":100,"description":"haha","price":200.0,"goods_img":"www","goods_status":"hao","sales":100,avgstar:5},
// {"goods_id":4,"type_id":2,"goods_name":"饮料零食2","inventory":100,"description":"haha","price":200.0,"goods_img":"www","goods_status":"hao","sales":100,avgstar:5}],
// "type":"饮料零食"}]
public class GoodsByType {
    List<Goods> list;
    String type;

    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GoodsByType(List<Goods> list, String type){
        this.list = list;
        this.type = type;
    }

    public  GoodsByType(){}
}
