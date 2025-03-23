package com.it.pkj.infrastructure.system;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
