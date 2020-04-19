package cn.cupbread.glanzz.Interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2020/2/26
 * @Author: CupOfBread
 * @Description:
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BackstageInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/test","/login","/code/**");
        super.addInterceptors(registry);
    }
}
