package cn.yangjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/testException1")
    public String testException1() {
        int[] arr = new int[8];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        System.out.println(1/0);
        return "success";
    }

    @RequestMapping("/testException2")
    public String testException2() {
        String msg = null;
        System.out.println(msg.toString());
        return "success";
    }
}
