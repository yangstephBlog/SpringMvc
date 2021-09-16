package cn.yangjc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdviceComponent {

    /**
     * 配置全局空指针异常处理，跳转到error页面
     */
    @ExceptionHandler({NullPointerException.class})
    public String exceptionHandler(Model model,Exception e) {
        model.addAttribute("msg",e);
        return "error";
    }
}
