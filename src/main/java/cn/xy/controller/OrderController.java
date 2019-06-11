package cn.xy.controller;

import cn.xy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/modifyOrderStatus",method = RequestMethod.POST)
    @ResponseBody
    public void modifyOrderStatus(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        int od_id = (int) map.get("od_id");
        String details_status = (String) map.get("newstatus");
        orderService.modifyStatus(od_id,details_status);
    }

    @RequestMapping(value = "/deleteDetails",method = RequestMethod.POST)
    @ResponseBody
    public void deleteDetails(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        int od_id = (int) map.get("od_id");
        orderService.deleteDetails(od_id);
    }




}
