package cn.yangjc.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 基于注解的异常统一处理
 */
@ControllerAdvice
public class ExceptionComponent {

    /**
     * 指定需要处理的异常类型
     */
    @ExceptionHandler(value = {ArithmeticException.class,ArrayIndexOutOfBoundsException.class,NullPointerException.class})
    public String handlerException(Model model,Exception e) {
        model.addAttribute("ex_msg",e);
        return "error";
    }
}
