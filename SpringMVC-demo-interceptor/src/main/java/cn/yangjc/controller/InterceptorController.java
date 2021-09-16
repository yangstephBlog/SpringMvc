package cn.yangjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterceptorController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/testInterceptor")
    @ResponseBody
    public String testInterceptor() {
        return "test pass!!!";
    }

    @GetMapping("/test/second")
    @ResponseBody
    public String testInterceptor2() {
        return "test pass[2]!!!";
    }
}
