package com.marina.java;

import java.util.ArrayList;

public class TextProcessor {

  public static boolean IsExtSymbol(char ch) {
    return ch == '<' || ch == '>' || (ch > 57000 && ch < 58000) || ch == ':' ;
  }

  public static boolean isNormal(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isLetterOrDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static ArrayList<String> normalize(String msg) {
    return normalize(getWords(msg));
  }

  public static ArrayList<String> normalize(ArrayList<String> words) {
    ArrayList<String> res = new ArrayList<>();
    for (String word : words) {
      if (isNormal(word) && word.length() > 3) {
        if (word.length() >= 5) {
          word = word.substring(0, word.length() - 2);
        }
        res.add(word.toLowerCase());
      }
    }
    return res;
  }

  public static ArrayList<String> getWords(String msg) {
    ArrayList<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean ext = false;
    for (int i = 0; i < msg.length(); i++) {
      char ch = msg.charAt(i);
      if (ext) {
        if (Character.isDigit(ch) || IsExtSymbol(ch)) {
          sb.append(ch);
        } else {
          ext = false;
          if (sb.length() > 0) {
            res.add(sb.toString());
            sb.setLength(0); //clear
          }
        }
      }
      if (!ext) {
        if (Character.isLetterOrDigit(ch)) {
          sb.append(ch);
        } else {
          if (sb.length() > 0) {
            res.add(sb.toString());
            sb.setLength(0);
          }
          if (IsExtSymbol(ch)) {
            sb.append(ch);
            ext = true;
          }
        }
      }
    }

    if (sb.length() > 0) {
      res.add(sb.toString());
    }

    return res;
  }

}
