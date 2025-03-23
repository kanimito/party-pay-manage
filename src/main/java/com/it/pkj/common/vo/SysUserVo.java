package com.it.pkj.common.vo;

import lombok.Data;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.common.vo
 * @Author: kanimito
 * @CreateTime: 2025-03-22  21:46
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class SysUserVo {
    private Integer id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String userType;

    /**
     *
     */
    private Integer memberId;
}
