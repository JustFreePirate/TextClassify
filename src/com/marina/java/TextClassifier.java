package com.marina.java;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TextClassifier {
  private Map<String, TextClass> textClasses = new HashMap<>();
  private int countDocs = 0; //общее кол-во документов
  private HashSet<String> allWords = new HashSet<>();

  public void study(ArrayList<String> normWords, String className) {
    TextClass textClass = textClasses.get(className);
    if (textClass == null) {
      textClass = new TextClass();
      textClasses.put(className, textClass);
    }
    textClass.add(normWords);
    countDocs++;

    for (String w : normWords) {
      allWords.add(w);
    }
  }

  public String getClassName(ArrayList<String> words) {
    double max = Double.NEGATIVE_INFINITY;
    String clName = null;
    for (Map.Entry<String, TextClass> entry : textClasses.entrySet()) {
      //calc
      TextClass cl = entry.getValue();
      double val = Math.log((double) cl.countDocs / countDocs);
      for (String w : words) {
        val += Math.log((double) (cl.words.count(w) + 1) / (allWords.size() + cl.countWords));
      }
      if (val > max) {
        max = val;
        clName = entry.getKey();
      }
    }
    return clName;
  }

}