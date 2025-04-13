package com.it.pkj.config;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.config
 * @Author: kanimito
 * @CreateTime: 2025-03-23  17:33
 * @Description: TODO
 * @Version: 1.0
 */

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
