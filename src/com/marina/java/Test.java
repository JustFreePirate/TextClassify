package com.marina.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Test {

  public static String[] classes = {"business", "travel", "forces", "media", "sport", "science", "style", "culture", "life", "economics"};

  public static void main(String[] args) throws Exception {
    TextClassifier textClassifier = new TextClassifier();
    BufferedReader br = new BufferedReader(new FileReader("news_train.txt"));
    try {
      String line = br.readLine();

      while (line != null) {
        ArrayList<String> words = TextProcessor.normalize(line);
        for (String cl : classes) {
          if (line.startsWith(cl)) {
            textClassifier.study(words, cl);
          }
        }
        line = br.readLine();
      }
    } finally {
      br.close();
    }

    br = new BufferedReader(new FileReader("news_test.txt"));
    ArrayList<String> lines = new ArrayList<>(16000);
    try {
      String line = br.readLine();
      while (line != null) {
        String cl = textClassifier.getClassName(TextProcessor.normalize(line));
        lines.add(cl);
        line = br.readLine();
      }
    } finally {
      br.close();
    }

    Files.write(Paths.get("output.txt"), lines);
  }

}
