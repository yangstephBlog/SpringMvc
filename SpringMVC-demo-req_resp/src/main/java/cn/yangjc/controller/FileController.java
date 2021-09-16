package cn.yangjc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;


@Controller
public class FileController {

    /**
     * 测试文件下载
     */
    @RequestMapping("/testDownFile")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session,String srcPath,String downloadFileName) throws IOException {
        ServletContext servletContext = session.getServletContext();
        // 获取下载真实地址
        String filePath = servletContext.getRealPath(srcPath);
        // 获取输入流对象
        InputStream inputStream = new FileInputStream(filePath);
        // 分配字节数组空间
        byte[] bytes = new byte[inputStream.available()];
        // 读入字节数组
        inputStream.read(bytes);
        // 创建HttpHeaders对象获取响应头信息
        MultiValueMap<String,String> headers = new HttpHeaders();
        downloadFileName = new String(downloadFileName.getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1);
        // 设置要下载的方式以及下载文件名称(这里的属性名称要写正确)
        headers.add("Content-Disposition","attachment;filename="+downloadFileName);
        // 设置响应状态码
        HttpStatus status = HttpStatus.OK;
        // 响应体对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, status);
        // 关闭流
        inputStream.close();
        return responseEntity;
    }

    /**
     * 测试文件上传
     */
    @RequestMapping("/testUpload")
    @ResponseBody
    public String testUpload(HttpSession session,@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String contextPath = session.getServletContext().getRealPath("/");
        File file = new File(contextPath+"/static/upload/"+multipartFile.getOriginalFilename());
        if (!file.exists())
            file.mkdir();
        multipartFile.transferTo(file);
        return "上传文件成功！";
    }
}
