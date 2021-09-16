package cn.yangjc.controller;

import cn.yangjc.bean.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    @ResponseBody
    public void testRequestBody(@RequestBody String requestBody) {
        System.out.println("请求体："+requestBody);
    }

    @RequestMapping(value = "/testRequestEntity",method = RequestMethod.POST)
    @ResponseBody
    public void testRequestEntity(RequestEntity<String> entity) {
        System.out.println("entity.getHeaders()="+entity.getHeaders());
        System.out.println("entity.getBody()="+entity.getBody());
    }

    /**
     * 因为pom.xml引入jackson-databind依赖会将java对象转换为json字符串
     */
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public Company testResponseBody(Company company) {
        return company;
    }

    @PostMapping("/testResponseEntity")
    public ResponseEntity<String> testResponseEntity() {
        return new ResponseEntity<String>("响应体", HttpStatus.OK);
    }

}
