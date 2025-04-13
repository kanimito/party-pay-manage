package com.it.pkj.service;

import com.it.pkj.common.vo.SysUserVo;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.service
 * @Author: kanimito
 * @CreateTime: 2025-03-22  21:47
 * @Description: TODO
 * @Version: 1.0
 */
public interface LoginService {

    public String login(SysUserVo userVo);

    void register(SysUserVo userVo);

    void logout(String token);
}
