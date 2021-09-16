package cn.yangjc.config;

import cn.yangjc.constant.Constant;
import cn.yangjc.interceptor.AnnotationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;



/**
 * 类比于SpringMVC.xml
 * 在其配置文件中可实现的功能有：
 * （1）扫描组件ComponentScan
 * （2）模板视图解析器
 * （3）开启注解驱动
 * （4）处理视图控制器
 * （5）处理静态资源
 * （6）文件上传解析器
 * （7）拦截器
 * （8）异常通知处理
 */
@Configuration
@ComponentScan(basePackages = {"cn.yangjc.*"})
// 开启注解驱动
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {


    /**
     * 首先定义一个thymeleaf模板视图解析器，将定义的bean放入IOC容器中
     */
    @Bean
    public ITemplateResolver iTemplateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(webApplicationContext.getServletContext());
        templateResolver.setSuffix(Constant.SUFFIX);
        templateResolver.setPrefix(Constant.PREFIX);
        templateResolver.setCharacterEncoding(Constant.ENCODING);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    /**
     * 模板引擎，自动装配模板解析器
     */
    @Bean
    public ISpringTemplateEngine springTemplateEngine(ITemplateResolver iTemplateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(iTemplateResolver);
        return springTemplateEngine;
    }

    /**
     * 视图解析器
     */
    @Bean
    public ViewResolver viewResolver(ISpringTemplateEngine iSpringTemplateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setCharacterEncoding(Constant.ENCODING);
        viewResolver.setTemplateEngine(iSpringTemplateEngine);
        return viewResolver;
    }

    /**
     * 增加视图控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 访问首页
        registry.addViewController("/").setViewName("index");
        // 访问测试页面
        registry.addViewController("/test").setViewName("test");
    }

    /**
     * 启动默认servlet处理器（处理静态资源）
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 增加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        AnnotationInterceptor annotationInterceptor = new AnnotationInterceptor();
        // 排除拦截首页
        registry.addInterceptor(annotationInterceptor).addPathPatterns("/**","/test").excludePathPatterns("/");
    }

    /**
     * 声明文件上传的文件解析器
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding(Constant.ENCODING);
        multipartResolver.setMaxUploadSizePerFile(Constant.MAX_UPLOAD_SIZE_PER_FILE);
        return multipartResolver;
    }

}
