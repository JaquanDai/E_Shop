package cn.xy.controller;


import cn.xy.bean.User;
import cn.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
