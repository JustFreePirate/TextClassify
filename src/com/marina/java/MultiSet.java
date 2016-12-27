package com.marina.java;

import java.util.HashMap;
import java.util.Map;

public class MultiSet<T> {
  private Map<T, Integer> set = new HashMap();

  public int count(T o) {
    Integer res = set.get(o);
    return res == null ? 0 : res;
  }

  public void add(T o) {
    Integer cur = set.get(o);
    if (cur == null) {
      cur = 0;
    }
    set.put(o, cur + 1);
  }

}
