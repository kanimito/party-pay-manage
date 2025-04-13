package com.it.pkj.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName party_fee_payment
 */
@TableName(value ="party_fee_payment")
@Data
public class PartyFeePayment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer memberId;

    /**
     * 
     */
    private Date paymentTime;

    /**
     * 
     */
    private BigDecimal paymentAmount;

    /**
     * 
     */
    private String paymentMethod;

    /**
     * 
     */
    private String paymentStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}