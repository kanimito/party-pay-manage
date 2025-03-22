package com.it.pkj.common.exception;

import com.it.pkj.common.BaseEnum;
import lombok.Getter;

/**
 * @Description 业务异常-基础异常类,如有需要可自行继承该异常 @Date 2023/9/11 15:24 @Created by 杨过
 */
@Getter
public class BusinessException extends RuntimeException {
  private Integer errorCode;
  private BaseEnum msg;
  private Object data;

  /** msg：业务异常原因 */
  public BusinessException(BaseEnum msg) {
    super(msg.getName());
    this.msg = msg;
    this.errorCode = msg.getCode();
  }

  /** msg：业务异常原因 data : 业务数据 */
  public BusinessException(BaseEnum msg, Object data) {
    super(msg.getName());
    this.msg = msg;
    this.errorCode = msg.getCode();
    this.data = data;
  }
}
