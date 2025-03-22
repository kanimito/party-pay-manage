package com.it.pkj.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName party_member
 */
@TableName(value ="party_member")
@Data
public class PartyMember implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String gender;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private Date joinPartyTime;

    /**
     * 
     */
    private String partyOrganization;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String email;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}