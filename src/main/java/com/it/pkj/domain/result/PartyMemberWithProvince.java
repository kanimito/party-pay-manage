package com.it.pkj.domain.result;

/**
 * @BelongsProject: partyPayManage
 * @BelongsPackage: com.it.pkj.domain.result
 * @Author: kanimito
 * @CreateTime: 2025-03-23  17:18
 * @Description: TODO
 * @Version: 1.0
 */
import lombok.Data;

import java.util.Date;

@Data
public class PartyMemberWithProvince {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private Date joinPartyTime;
    private Integer provinceId;
    private String phone;
    private String email;
    private String organizationType;
    private String provinceName;
}