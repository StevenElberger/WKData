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

  public Radical(String type, String character, String[] meaning, 
                      String image, int level, long unlockedDate) {
    super(type, character, meaning, level, unlockedDate);
    this.image = image;
  }

  public String getImage() {
    return image;
  }
}