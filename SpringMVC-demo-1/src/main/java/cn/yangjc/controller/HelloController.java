package cn.yangjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实际控制请求类
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "index";
    }


    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }

    @RequestMapping("/goTest")
    public String toTest() {
        return "test";
    }

}
