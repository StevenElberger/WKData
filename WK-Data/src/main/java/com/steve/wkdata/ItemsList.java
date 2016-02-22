package com.steve.wkdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * The list of items (recent unlocks or critical).
 * Consists of radicals, kanji, or vocabulary items.
 * @author Steve
 */
@JsonDeserialize(using = ItemsListDeserializer.class)
public class ItemsList {
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
  private Item[] list;

  /**
   * Constructor.
   * @param list the list of items
   * @param lastRefreshed the time this object was constructed (expiration purposes)
   */
  public ItemsList(Item[] list, long lastRefreshed) {
    this.list = list;
    this.lastRefreshed = lastRefreshed;
  }

  /**
   * Checks if the data has expired.
   * @return true if expired, false otherwise
   */
  public boolean isExpired() {
    return System.currentTimeMillis() - EXPIRATION_TIME >= lastRefreshed;
  }

  public long getLastRefreshed() {
    return lastRefreshed;
  }

  public Item[] getList() {
    return list;
  }
}