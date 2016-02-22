package com.steve.wkdata;

/**
 * A radical item. Returned in Recent Unlocks List
 * and Critical Items List API calls.
 * @author Steve
 */
public class Radical extends Item {
  /**
   * The URL for the radical's image. (may be {@code null})
   */
  private String image;

  /**
   * Constructor.
   * @param type the item type
   * @param character the character(s)
   * @param meaning the meaning(s)
   * @param image the image, if applicable
   * @param level the level at which unlocked
   * @param unlockedDate the date at which unlocked
   * @param percentage the percentage the item has been reviewed correctly
   */
  public Radical(String type, String character, String[] meaning, 
                      String image, int level, Long unlockedDate, Integer percentage) {
    super(type, character, meaning, level, unlockedDate, percentage);
    this.image = image;
  }

  public String getImage() {
    return image;
  }
}