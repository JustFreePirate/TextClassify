package com.marina.java;

import java.util.ArrayList;

public class TextProcessor {

  public static ArrayList<String> normalize(String msg) {
    return normalize(getWords(msg));
  }

  public static ArrayList<String> normalize(ArrayList<String> words) {
    ArrayList<String> res = new ArrayList<>();
    for (String word : words) {
      if (word.length() > 3) {
        res.add(word.toLowerCase());
      }
    }
    return res;
  }

  public static ArrayList<String> getWords(String msg) {
    ArrayList<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < msg.length(); i++) {
      char ch = msg.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        sb.append(ch);
      } else {
        if (sb.length() > 0) {
          res.add(sb.toString());
          sb.setLength(0);
        }
      }
    }

    if (sb.length() > 0) {
      res.add(sb.toString());
    }

    return res;
  }

}
