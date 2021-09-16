package cn.yangjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/getMessage")
    @ResponseBody
    public String getMessage(Model model) {
        model.addAttribute("msg","this is a SpringMVC project！");
        return (String) model.getAttribute("msg");
    }

    @GetMapping("/getExceptionMessage")
    @ResponseBody
    public String getExceptionMessage() {
        String msg = null;
        System.out.println(msg.toLowerCase());
        return msg;
    }

    /**
     * 文件上传成功
     */
    @PostMapping("/testFileUpload")
    @ResponseBody
    public String testFileUpload(HttpSession session, @RequestParam("file")MultipartFile multipartFile) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/");
        File file = new File(realPath + "/static/upload/" + multipartFile.getOriginalFilename());
        if (!file.exists())
            file.mkdir();
        multipartFile.transferTo(file);
        return "upload file success";
    }
}
