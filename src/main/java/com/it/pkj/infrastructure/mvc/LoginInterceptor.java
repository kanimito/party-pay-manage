package com.it.pkj.infrastructure.mvc;

import com.it.pkj.domain.SystemUser;
import com.it.pkj.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.infrastructure.mvc
 * @Author: kanimito
 * @CreateTime: 2025-03-23  14:11
 * @Description: TODO
 * @Version: 1.0
 */
//@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 执行了拦截器的preHandle方法
        // 1. 获取请求头中的token
        String token = request.getHeader("Authorization");
        // 2. 校验token
        if (token == null || token.equals("")) {
            throw new RuntimeException("未授权");
        }
        String tid = jwtUtil.parseToken(token);
        String storedToken = (String) redisTemplate.opsForValue().get(tid);
        if (storedToken == null || !storedToken.equals(token)) {
            throw new RuntimeException("未授权");
        }
        // 获取用户对象并存储到请求属性中
        SystemUser user = jwtUtil.getUserObjectFromToken(token, SystemUser.class);
        request.setAttribute("user", user);
        return true;
    }

}
