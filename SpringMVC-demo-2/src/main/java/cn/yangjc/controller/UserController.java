package cn.yangjc.controller;

import cn.yangjc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(User user) {
        System.out.println("user="+user);
        return user.toString();
    }

    @RequestMapping("/sayHi")
    public void say() {
        System.out.println("你好！");
    }

}
