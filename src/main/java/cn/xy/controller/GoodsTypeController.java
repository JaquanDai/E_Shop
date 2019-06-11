package cn.xy.controller;

import cn.xy.bean.GoodsType;
import cn.xy.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping(value = "/addGoodsType",method = RequestMethod.POST)
    @ResponseBody
    public GoodsType addGoodsType(@RequestBody(required=true) Map<String,Object> map){

        GoodsType goodsType = new GoodsType();
        String type_name = (String)map.get(("type_name"));
        goodsType.setType_name(type_name);
        goodsType.setType_status("active");

        goodsTypeService.addGoodsType(type_name);

        return goodsType;
    }

    @RequestMapping(value = "/getTypeByOperatorId",method = RequestMethod.POST)
    @ResponseBody
    public List<GoodsType> getTypeByOperatorId(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){

        int operator_id = (Integer) map.get("operator_id");

        List<GoodsType> result = new ArrayList<>();
        result.addAll(goodsTypeService.getTypeByOperatorId(operator_id));

        return result;
    }
}
