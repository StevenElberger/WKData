package com.steve.wkdata;

/**
 * Base class for generic items returned in Recent
 * Unlocks List and Critical Items List API calls.
 * @author Steve
 */
public abstract class Item {
  /**
   * The type of item (radical, kanji, vocabulary).
   */
  private String type;
  /**
   * The item's character.
   */
  private String character;
  /**
   * The meaning(s) of the item.
   */
  private String[] meaning;
  /**
   * The level at which this item may be unlocked.
   */
  private int level;
  /**
   * The date this item was unlocked.
   */
  private long unlockedDate;
  /**
   * The percent this item has been reviewed correctly. (may be {@code null})
   */
  private Integer percentage;

  /**
   * Constructor.
   * @param type the item's type
   * @param character the item's character
   * @param meaning the item's meaning(s)
   * @param level the item's level at which it can be unlocked
   * @param unlockedDate the date at which the item was unlocked
   */
  public Item(String type, String character, 
          String[] meaning, int level, long unlockedDate) {
    this.type = type;
    this.character = character;
    this.meaning = meaning;
    this.level = level;
    this.unlockedDate = unlockedDate;
  }

  public void setPercentage(Integer percentage) {
    this.percentage = percentage;
  }

  public Integer getPercentage() {
    return percentage;
  }

  public String getType() {
    return type;
  }

  public String getCharacter() {
    return character;
  }

  public String[] getMeaning() {
    return meaning;
  }

  public int getLevel() {
    return level;
  }

  public long getUnlockedDate() {
    return unlockedDate;
  }
}