package com.it.pkj.common;

import lombok.Getter;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage: com.it.study.common @Author:
 * kanimito @CreateTime: 2024-08-12 11:46 @Description: TODO @Version: 1.0
 */
@Getter
public class PageResult<T> extends Result<T> {
  private Long total;

  protected PageResult(Integer code, String msg, T data, Long total) {
    super(code, msg, data);
    this.total = total;
  }

  public static <T> PageResult<T> ok(T data, Long total) {
    PageResult<T> result =
        new PageResult<>(CodeEnum.Ok.getCode(), CodeEnum.Ok.getName(), data, total);
    return result;
  }
}
