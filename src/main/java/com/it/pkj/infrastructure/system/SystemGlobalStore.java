package com.it.pkj.infrastructure.system;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * _ooOoo_ o8888888o 88" . "88 (| -_- |) O\ = /O ____/`---'\____ .' \\| |// `. / \\||| : |||// \ /
 * _||||| -:- |||||- \ | | \\\ - /// | | | \_| ''\---/'' | | \ .-\__ `-` ___/-. / ___`. .' /--.--\
 * `. . __ ."" '< `.___\_<|>_/___.' >'"". | | : `- \`.;`\ _ /`;.`/ - ` : | | \ \ `-. \_ __\ /__ _/
 * .-` / / ======`-.____`-.___\_____/___.-`____.-'====== `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 佛祖保佑 永无BUG 佛曰: 写字楼里写字间，写字间里程序员； 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠； 酒醉酒醒日复日，网上网下年复年。 但愿老死电脑间，不愿鞠躬老板前； 奔驰宝马贵者趣，公交自行程序员。 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？ @BelongsProject: SSM-doctor @BelongsPackage:
 * com.it.study.infrastructure.system @Author: kanimito @CreateTime: 2024-08-13 12:02 @Description:
 * TODO @Version: 1.0
 */
public class SystemGlobalStore {
  private static final Map<Object, Object> loginMap = new ConcurrentHashMap<>();

  public static void setAttr(String key, Object value) {
    loginMap.put(key, value);
  }

  public static <T> T getAttr(String key) {
    return (T) loginMap.get(key);
  }

  public static void removeAttr(String key) {
    loginMap.remove(key);
  }
}
