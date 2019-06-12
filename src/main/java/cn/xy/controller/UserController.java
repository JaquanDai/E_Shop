package cn.xy.controller;


import cn.xy.bean.User;
import cn.xy.bean.UserAddress;
import cn.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/{user_id}")
    @ResponseBody
    public User findUserById(@PathVariable("user_id") int userId){
        User user = userService.findUserById(userId);
        System.out.println("name"+user.getUser_name());
        return user;
    }

    @RequestMapping("/operator")
    public void test(){
//        User user = userService.findUserById(userId);
//        System.out.println("name"+user.getUser_name());
//        return user;
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public Map checkLogin(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        User user = new User();

        HttpSession session =request.getSession();
        String userAccount=(String) map.get("userAccount");
        String pwd=(String) map.get("pwd");
        Map result=userService.Login(userAccount,pwd);
        if((Integer) result.get("code")==0){
            session.setAttribute("userId",result.get("userId"));
        }
        return result;
    }

    @RequestMapping("/getUserInformation")
    @ResponseBody
    public Map getUserInformation(HttpServletRequest request){
        HttpSession session =request.getSession();
        int userId=(int) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        Map result=new HashMap();
        result.put("userName",user.getUser_name());
        result.put("userPhone",user.getUser_phone());
        result.put("userAccount",user.getUser_account());
        return result;
    }

    @RequestMapping("/modifyInformation")
    @ResponseBody
    public void modifyInformation(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        HttpSession session =request.getSession();
        int userId=(int) session.getAttribute("userId");
        String userName=(String) map.get("userName");
        String userPhone=(String) map.get("userPhone");
//        System.out.println("modifyInformation:"+userName+"  "+userPhone);
        userService.modifyUsername(userId, userName);
        userService.modifyUserPhone(userId, userPhone);
    }

    @RequestMapping("/modifyPwd")
    @ResponseBody
    public Map modifyPwd(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        Map<String,Object> result = new HashMap();
        HttpSession session =request.getSession();
        int userId=(int) session.getAttribute("userId");
        String oldPwd=(String) map.get("oldPwd");
        String newPwd=(String) map.get("newPwd");
        result = userService.checkPwd(userId, oldPwd);
        if ((int)result.get("code")==-1){
            result.put("message","原密码错误");
        }else {
            userService.modifyUserPwd(userId, newPwd);
            result.put("message","修改成功");
        }
        return result;
    }

    @RequestMapping("/getUserAddress")
    @ResponseBody
    public List<UserAddress> getUserAddress(HttpServletRequest request){
        HttpSession session =request.getSession();
        int userId=(int) session.getAttribute("userId");
        List<UserAddress> userAddresses = userService.getAllUserAddress(userId);
        return userAddresses;
    }

    @RequestMapping("/modifyUserAddress")
    @ResponseBody
    public void modifyUserAddress(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        int uaId=(int) map.get("uaId");
        String address = (String) map.get("address");
        userService.modifyAddress(uaId, address);
    }

    @RequestMapping("/deleteUserAddress")
    @ResponseBody
    public void deleteUserAddress(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        int uaId=(int) map.get("uaId");
        userService.delAddress(uaId);
    }

    @RequestMapping("/addUserAddress")
    @ResponseBody
    public Map addUserAddress(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        HttpSession session =request.getSession();
        int userId = (int) session.getAttribute("userId");
        String address = (String) map.get("address");
        Map result = userService.addAddress(userId, address);
        return  result;
    }

    @RequestMapping("/changeUserAddressStatus")
    @ResponseBody
    public void changeUserAddressStatus(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request){
        HttpSession session =request.getSession();
        int userId = (int) session.getAttribute("userId");
        int uaId=(int) map.get("uaId");
        String status = (String) map.get("status");
        if (status == null){
            userService.cancelDefaultAddress(uaId);
        }else if(status.equals("default")){
            userService.setAddress(uaId, userId);
        }
    }

}
