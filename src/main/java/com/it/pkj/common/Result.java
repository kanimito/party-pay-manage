package com.it.pkj.common;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/** Http请求通用的返回结果对象 */
@Getter
@ToString
public class Result<T> implements Serializable {
  /** 自定义的响应状态码 */
  protected Integer code;

  /** 响应消息提示 */
  protected String msg;

  /** 响应的数据 */
  protected T data;

  protected Result(Integer code, String msg, T data) {
    this.data = data;
    this.code = code;
    this.msg = msg;
  }

  /** 请求成功 */
  public static <T> Result<T> ok() {
    Result<T> result = new Result<T>(CodeEnum.Ok.getCode(), CodeEnum.Ok.getName(), null);
    return result;
  }

  public static <T> Result<T> ok(T data) {
    Result<T> result = new Result<T>(CodeEnum.Ok.getCode(), CodeEnum.Ok.getName(), data);
    return result;
  }

  /** 自定义状态码 */
  public static <T> Result<T> ok(T data, BaseEnum baseEnum) {
    Result<T> result = new Result<T>(baseEnum.getCode(), baseEnum.getName(), data);
    return result;
  }

  /** 请求失败 */
  public static <T> Result<T> fail() {
    Result<T> result = new Result<T>(CodeEnum.Fail.getCode(), CodeEnum.Fail.getName(), null);
    return result;
  }

  public static <T> Result<T> fail(BaseEnum codeEnum) {
    Result<T> result = new Result<T>(codeEnum.getCode(), codeEnum.getName(), null);
    return result;
  }

  public static <T> Result<T> fail(String msg) {
    Result<T> result = new Result<T>(CodeEnum.Fail.getCode(), msg, null);
    return result;
  }

  public static <T> Result<T> fail(BaseEnum codeEnum, T data) {
    Result<T> result = new Result<T>(codeEnum.getCode(), codeEnum.getName(), data);
    return result;
  }
}
