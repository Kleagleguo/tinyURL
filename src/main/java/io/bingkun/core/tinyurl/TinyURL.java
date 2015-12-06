package io.bingkun.core.tinyurl;

/**
 * @author Bingkun Guo
 */
public interface TinyURL
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
