package cn.xy.controller;

import cn.xy.bean.*;
import cn.xy.dao.CommentsDao;
import cn.xy.dao.GoodsDao;
import cn.xy.service.CommentsService;
import cn.xy.service.GoodsService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OperatorController {

    @Autowired
    private OperatorService operatorService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private GoodsService goodsService;

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

    @RequestMapping(value = "/addOperator",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Integer> addOperator(@RequestBody(required=true) Map<String,Object> map){

        String operator_account = (String)map.get("operator_account");
        String operator_pwd = (String)map.get("operator_pwd");

        return operatorService.addOperator(operator_account,operator_pwd);

    }

    @RequestMapping(value = "/getOperatorByType",method = RequestMethod.POST)
    @ResponseBody
    public List<Operator> getOperatorByType(@RequestBody(required=true) Map<String,Object> map){

        int type_id = (int)map.get("type_id");

        return operatorService.getOperatorByType(type_id);

    }

    @RequestMapping(value = "/modifyOperatorPwd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Integer> modifyOperatorPwd(@RequestBody(required=true) Map<String,Object> map,HttpServletRequest request){

        Map<String,Integer> result = new HashMap<>();

        HttpSession session =request.getSession();
        int operatorId = (int) session.getAttribute("operatorId");

        String oldPwd = (String)map.get("oldPwd");
        String newPwd1 = (String)map.get("newPwd1");
        String newPwd2 = (String)map.get("newPwd2");

        if(!newPwd1.equals(newPwd2)){
            result.put("code",-2);
            return result;
        }
        if(newPwd1.equals("")||newPwd2.equals("")){
            result.put("code",-3);
            return result;
        }
        result = operatorService.modifyOperatorPwd(operatorId,newPwd1,oldPwd);
        return result;

    }

    @RequestMapping(value = "/getCommentByOperator",method = RequestMethod.POST)
    @ResponseBody
    public List<OperatorComments> getCommentByOperator(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        List<OperatorComments> operatorComments = new ArrayList<>();
        HttpSession session =request.getSession();
        int operatorId = (int) session.getAttribute("operatorId");
        List<CommentsReply> commentsReplies = new ArrayList<>();
        List<GoodsType> goodsTypes = operatorService.getGoodsTypeByOperator(operatorId);
        for(int i=0;i<goodsTypes.size();i++){
            List<Goods> goods = operatorService.getGoodsByType(goodsTypes.get(i).getType_id());
            for(int j=0;j<goods.size();j++){
                commentsReplies.addAll(commentsService.getGoodsComments(goods.get(j).getGoods_id()));
            }
        }

        for(int i=0;i<commentsReplies.size();i++){
            OperatorComments e = new OperatorComments();
            e.setComments(commentsReplies.get(i).getComments());
            Goods goods = goodsService.getGoodsById(commentsReplies.get(i).getComments().getGoods_id());
            e.setGoodsNmae(goods.getGoods_name());
            e.setReplyList(commentsReplies.get(i).getReplyList());
            e.setUserName(commentsReplies.get(i).getUserName());
            operatorComments.add(e);
        }

        return operatorComments;

    }




}
