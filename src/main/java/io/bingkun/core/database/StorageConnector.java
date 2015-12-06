package io.bingkun.core.database;

import java.util.Map;

/**
 * @author Bingkun Guo
 **/
public interface StorageConnector
{
  boolean insert(String longURL, String shortURL);

  String lookup(String longURL);

  /**
   * @return a Map that maps long URL to short URL
   */
  Map<String,String> populateMap();
}
