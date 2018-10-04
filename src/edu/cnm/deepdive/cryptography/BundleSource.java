package edu.cnm.deepdive.cryptography;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BundleSource implements WordSource {

  private ArrayList<String> words;

  public BundleSource(String basename) {
    ResourceBundle bundle = ResourceBundle.getBundle(basename);
    words = new ArrayList<>(
        bundle.keySet().stream() //keyset method returns set, then returns stream of strings
            .map((k) -> bundle.getString(k)) //map returns a stream transformed to another string value
            .collect(Collectors.toList())
        //stream has method collect, returns a list of strings then use
        //that as an argument for the Array List
    );
  }

  @Override
  public String get(int i) {
    return words.get(i);
  }

  @Override
  public int size() {
    return words.size();
  }
}
