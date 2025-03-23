package com.it.pkj.config;

import com.it.pkj.infrastructure.mvc.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.config
 * @Author: kanimito
 * @CreateTime: 2025-03-23  14:15
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**") // 拦截所有路径
                .excludePathPatterns("/security/**"); // 排除登录路径
    }
}
