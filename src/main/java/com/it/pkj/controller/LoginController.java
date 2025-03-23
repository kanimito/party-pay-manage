package com.it.pkj.controller;

import com.it.pkj.common.Result;
import com.it.pkj.common.vo.SysUserVo;
import com.it.pkj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private LoginService loginService;
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
}
