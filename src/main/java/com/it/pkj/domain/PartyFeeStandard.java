package com.it.pkj.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName party_fee_standard
 */
@TableName(value ="party_fee_standard")
@Data
public class PartyFeeStandard implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer provinceId;

    /**
     * 
     */
    private String organizationType;

    /**
     * 
     */
    private String incomeType;

    /**
     * 
     */
    private BigDecimal feeRate;

    /**
     * 
     */
    private BigDecimal fixedAmount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}