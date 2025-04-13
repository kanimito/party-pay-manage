package com.it.pkj.controller;

import com.it.pkj.common.Result;
import com.it.pkj.common.vo.SysUserVo;
import com.it.pkj.domain.SystemUser;
import com.it.pkj.service.LoginService;
import com.it.pkj.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.controller
 * @Author: kanimito
 * @CreateTime: 2025-03-22  21:43
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/security")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    public Result<String> login(@RequestBody SysUserVo userVo) {
        String token = loginService.login(userVo);
        return Result.ok(token);
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody SysUserVo userVo) {
        loginService.register(userVo);
        return Result.ok();
    }

    @GetMapping("/info")
    public Result<SystemUser> info(HttpServletRequest request) {
        SystemUser user = (SystemUser) request.getAttribute("user");
        return Result.ok(user);
    }

    @GetMapping("/logout")
    public Result<String> logout(@RequestHeader("token") String token) {
        try {
            // 从 Redis 中移除用户的 token 信息
            String tid = jwtUtil.parseToken(token);
            Boolean result = redisTemplate.delete(tid);
            if (result != null && result) {
                loginService.logout(token);
                return Result.ok("登出成功");
            } else {
                return Result.fail("登出失败，token 不存在或已过期");
            }
        } catch (Exception e) {
            logger.error("登出接口出现异常: ", e);
            return Result.fail("登出失败，服务器内部错误");
        }
    }
}
