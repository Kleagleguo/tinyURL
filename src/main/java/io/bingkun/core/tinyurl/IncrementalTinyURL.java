package io.bingkun.core.tinyurl;

import io.bingkun.core.database.StorageConnector;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bingkun Guo
 **/
public class IncrementalTinyURL implements TinyURL
{
  private final StorageConnector connector;
  private final Map<String, String> shortToLongMap;
  private final Map<String, String> longToShortMap;
  private int count;

  public IncrementalTinyURL(StorageConnector connector)
  {
    this.connector = connector;
    longToShortMap = connector.populateMap();
    shortToLongMap = new HashMap<String, String>();
    for (Map.Entry<String, String> entry : longToShortMap.entrySet()) {
      shortToLongMap.put(entry.getValue(), entry.getKey());
    }
    count = longToShortMap.size();
  }

  public String shortToLong(String shortURL)
  {
    return shortToLongMap.get(shortURL);
  }

  public synchronized String longToShort(String longURL)
  {
    String shortURL = longToShortMap.get(longURL);
    if (shortURL == null) {
      shortURL = generateShortURL(longURL);
      connector.insert(longURL, shortURL);
      longToShortMap.put(longURL, shortURL);
      shortToLongMap.put(shortURL, longURL);
    }
    return shortURL;
  }

  private String generateShortURL(String shortURL)
  {
    return null;
  }
}
