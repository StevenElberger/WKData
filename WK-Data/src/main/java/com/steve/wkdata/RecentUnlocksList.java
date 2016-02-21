package com.steve.wkdata;

/**
 * The list of recently unlocked items.
 * Consists of radicals, kanji, or vocabulary items.
 * @author Steve
 */
public class RecentUnlocksList {
  /**
   * The list of recently unlocked items.
   * Can be radicals, kanji, or vocabulary items.
   */
  private Item[] list;

  /**
   * Constructor.
   * @param list the list of items
   */
  public RecentUnlocksList(Item[] list) {
    this.list = list;
  }

  public Item[] getList() {
    return list;
  }
}