package cn.xy.controller;

import cn.xy.bean.GoodsType;
import cn.xy.bean.Operator;
import cn.xy.bean.OperatorOrderDetails;
import cn.xy.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping(value = "/checkoperatorlogin",method = RequestMethod.POST)
    @ResponseBody
    public Map OperatorLogin(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request) throws Exception {
        HttpSession session =request.getSession();
        String operatorId=(String) map.get("operatorAccount");
        String pwd=(String) map.get("pwd");
        Map result=operatorService.operatorLogin(operatorId,pwd);
        if((Integer) result.get("code")==0){
            session.setAttribute("operatorId",result.get("operatorId"));
        }
        return result;
    }

    @RequestMapping(value = "/listOrderDetails",method = RequestMethod.POST)
    @ResponseBody
    public List<OperatorOrderDetails> listOrderDetails(HttpServletRequest request) throws Exception {
        HttpSession session =request.getSession();
        List<OperatorOrderDetails> result = new ArrayList<>();
        int operatorId = (int) session.getAttribute("operatorId");

        result = operatorService.getOrderDetailsByOperator(operatorId);

        return result;
    }

    @RequestMapping(value = "/listGoodsByOperator",method = RequestMethod.POST)
    @ResponseBody
    public List<OperatorOrderDetails> listGoodsByOperator(HttpServletRequest request) throws Exception {
        HttpSession session =request.getSession();
        List<OperatorOrderDetails> result = new ArrayList<>();
        int operatorId = (int) session.getAttribute("operatorId");

        result = operatorService.getOrderDetailsByOperator(operatorId);

        return result;
    }

    @RequestMapping(value = "/listTypeByOperator",method = RequestMethod.POST)
    @ResponseBody
    public List<GoodsType> listTypeByOperator(HttpServletRequest request) throws Exception {
        HttpSession session =request.getSession();
        List<GoodsType> result = new ArrayList<>();
        int operatorId = (int) session.getAttribute("operatorId");

        result = operatorService.getGoodsTypeByOperator(operatorId);

        return result;
    }

    @RequestMapping(value = "/getNormalOperator",method = RequestMethod.POST)
    @ResponseBody
    public List<Operator> getNormalOperator(){
        return operatorService.getNormalOperator();
    }



}
