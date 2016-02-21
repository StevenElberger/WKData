package com.steve.wkdata;

/**
 * A kanji item. Returned in Recent Unlocks List
 * and Critical Items List API calls.
 * @author Steve
 */
public class Kanji extends Item {
  /**
   * The kanji's on'yomi reading.
   */
  private String onyomi;
  /**
   * The kanji's kun'yomi reading. (may be {@code null})
   */
  private String[] kunyomi;
  /**
   * The kanji's nanori reading.
   */
  private String nanori;
  /**
   * The kanji's important reading. (kunyomi or onyomi -maybe even nanori-?)
   */
  private String importantReading;

  public Kanji(String type, String character, 
          String[] meaning, String onyomi, String[] kunyomi, 
          String nanori, String importantReading, int level, long unlockedDate) {
    super(type, character, meaning, level, unlockedDate);
    this.onyomi = onyomi;
    this.kunyomi = kunyomi;
    this.nanori = nanori;
    this.importantReading = importantReading;
  }

  public String getOnyomi() {
    return onyomi;
  }

  public String[] getKunyomi() {
    return kunyomi;
  }

  public String getNanori() {
    return nanori;
  }

  public String getImportantReading() {
    return importantReading;
  }
}