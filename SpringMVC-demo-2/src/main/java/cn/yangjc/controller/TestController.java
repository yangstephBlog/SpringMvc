package cn.yangjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


    /**
     * 原生的servlet API 传输共享数据
     */
    @RequestMapping("/testRequestParam1")
    public String testRequestParam1(HttpServletRequest request) {
        request.setAttribute("goal","采用HttpServletRequest共享数据");
        return "target";
    }

    @RequestMapping("/testRequestParam2")
    public ModelAndView testRequestParam2() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("goal","采用ModelAndView共享数据");
        mav.setViewName("target");
        return mav;
    }

    @RequestMapping("/testRequestParam3")
    public String testRequestParam3(Model model) {
        model.addAttribute("goal","采用Model共享数据");
        return "target";
    }

    @RequestMapping("/testRequestParam4")
    public String testRequestParam4(Map<String,Object> map) {
        map.put("goal","采用Map共享数据");
        return "target";
    }

    @RequestMapping("/testRequestParam5")
    public String testRequestParam5(ModelMap modelMap) {
        modelMap.addAttribute("goal","采用ModelMap共享数据");
        return "target";
    }
}
