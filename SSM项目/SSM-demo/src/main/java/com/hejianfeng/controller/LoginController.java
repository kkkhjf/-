package com.hejianfeng.controller;

import com.hejianfeng.pojo.Msg;
import com.hejianfeng.pojo.User;
import com.hejianfeng.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HJF
 * @create 2021/10/8
 */
@Controller
public class LoginController {

    @Autowired
    public LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkUser(User user, Model model){
        if(loginService.checkUser(user.getUserName()) == 0){
            System.out.println("进入Controller方法！" + "ID=" + user.getId());
            model.addAttribute("userError", "用户名未注册！");
            return "login";
        }else{
            return "abc";
        }
    }

    @RequestMapping(value = "/login/{userName}")
    @ResponseBody
    public Msg checkUser(@PathVariable("userName") String userName){
        System.out.println(userName);
        System.out.println(loginService.checkUser(userName) );
        if(loginService.checkUser(userName) == 0L){
            return Msg.fail();
        }else{
            return Msg.success();
        }
    }
}
