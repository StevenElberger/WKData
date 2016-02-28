package com.steve.wkdata;

/**
 * A vocabulary item. Returned in Recent Unlocks List
 * and Critical Items List API calls.
 * @author Steve
 */
public class Vocabulary extends Item {
  /**
   * The vocabulary item's kana.
   */
  private String kana;

  /**
   * Constructor.
   * @param type the type
   * @param character the character(s)
   * @param kana the kana
   * @param meaning the meaning(s)
   * @param level the level
   */
  public Vocabulary(String type, String character, 
          String kana, String[] meaning, int level) {
    super(type, character, meaning, level);
    this.kana = kana;
  }

  public String getKana() {
    return kana;
  }
}