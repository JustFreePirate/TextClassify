package com.marina.java;

import java.util.ArrayList;

public class TextClass {
  public MultiSet<String> words = new MultiSet<>();
  int countDocs = 0; //кол-во документов в этом классе
  int countWords = 0;

  public void add(ArrayList<String> words) {
    countDocs++;
    countWords += words.size();
    for (String w: words) {
      this.words.add(w);
    }
  }
}
