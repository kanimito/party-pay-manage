package com.it.pkj.common;

/** 系统内部操作状态码 */
public enum CodeEnum implements BaseEnum<CodeEnum> {
  Ok(0, "操作成功"),
  Fail(1, "操作失败"),
  NotFindError(10001, "未查询到信息"),
  SaveError(10002, "保存信息失败"),
  UpdateError(10003, "更新信息失败"),
  ValidateError(10004, "数据检验失败"),
  StatusHasValid(10005, "状态已经被启用"),
  StatusHasInvalid(10006, "状态已经被禁用"),
  SystemError(10007, "系统异常"),
  BusinessError(10008, "业务异常"),
  ParamSetIllegal(10009, "参数设置非法"),
  TransferStatusError(10010, "当前状态不正确，请勿重复提交"),
  NotGrant(10011, "没有操作该功能的权限，请联系管理员"),
  NotAuthorization(10012, "您还没有登录，请登录后再操作"),
  DeleteError(10086, "数据删除失败"),
  NotFoundError(10404, "访问地址不存在");
  private Integer code;
  private String msg;

  CodeEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public Integer getCode() {
    return code;
  }

  @Override
  public String getName() {
    return msg;
  }
}
