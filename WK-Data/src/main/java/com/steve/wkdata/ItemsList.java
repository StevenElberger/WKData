package com.steve.wkdata;

import java.util.ArrayList;

/**
 * The list of items (recent unlocks or critical).
 * Consists of radicals, kanji, or vocabulary items.
 * @author Steve
 */
public abstract class ItemsList implements Expirable {
  /**
   * The expiration time limit for this object. Set to 1 hour.
   */
  private static final long EXPIRATION_TIME = 60 * 60 * 1000;
  /**
   * The timestamp of the last time this object was refreshed with new data.
   */
  private long lastRefreshed = 0;
  /**
   * The list of items.
   * Can be radicals, kanji, or vocabulary items.
   */
  private ArrayList<Item> list;

  /**
   * Constructor.
   * @param list the list of items
   * @param lastRefreshed the time this object was constructed (expiration purposes)
   */
  public ItemsList(ArrayList<Item> list, long lastRefreshed) {
    this.list = list;
    this.lastRefreshed = lastRefreshed;
  }

  /**
   * Checks if the data has expired.
   * @return true if expired, false otherwise
   */
  @Override
  public boolean isExpired() {
    return System.currentTimeMillis() - EXPIRATION_TIME >= lastRefreshed;
  }

  public long getLastRefreshed() {
    return lastRefreshed;
  }

  public ArrayList<Item> getList() {
    return list;
  }
}