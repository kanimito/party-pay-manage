package com.it.pkj.common;

/** 枚举基础接口 注意：<T>泛型是用来限制当前接口只能被枚举类实现 */
public interface BaseEnum<T extends Enum<T> & BaseEnum<T>> {
  // 枚举状态码
  Integer getCode();

  // 枚举名称
  String getName();

  static <T extends Enum<T> & BaseEnum<T>> T parseByCode(Class<T> cls, Integer code) {
    // 获取枚举的所有选项
    Enum[] enumType = (Enum[]) cls.getEnumConstants();
    // 枚举类型的总数量
    int length = enumType.length;

    for (int i = 0; i < length; i++) {
      T t = (T) enumType[i];
      if (((BaseEnum) t).getCode() == code) {
        return t;
      }
    }

    return null;
  }
}
