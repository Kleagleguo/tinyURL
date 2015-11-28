package io.bingkun.core;

/**
 * Created by guobingkun on 11/27/15.
 */
public interface URLConverter
{
  /**
   * Convert a short URL to its corresponding long URL
   */
  String shortToLong(String shortURL);

  /**
   * Convert a long URL to its shorten URL
   */
  String longToShort(String longURL);
}
