package cn.yangjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class TestController {

    @RequestMapping({"/test","/testRequestMapping"})
    public String testRequestMapping() {
        return "success";
    }

    @RequestMapping(value = "/testRequestMapping",method = RequestMethod.POST)
    public String testRequestMapping2() {
        return "success";
    }

    @RequestMapping(value = "/testParamsAndHeader",params = "user=yangjc",headers = "HOST")
    public String testParamsAndHeader() {
        return "success";
    }

    @RequestMapping("/test/a?b")
    public String testAntStyle1() {
        System.out.println("testAntStyle1");
        return "target";
    }

    @RequestMapping("/test/a*b")
    public String testAntStyle2() {
        System.out.println("testAntStyle2");
        return "target";
    }

    @RequestMapping("/test/**/boy")
    public String testAntStyle3() {
        System.out.println("testAntStyle3");
        return "target";
    }

}
