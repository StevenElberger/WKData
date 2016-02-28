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

  /**
   * Constructor.
   * @param type the type
   * @param character the character
   * @param meaning the meaning(s)
   * @param onyomi the on'yomi
   * @param kunyomi the kun'yomi
   * @param nanori the nanori
   * @param importantReading the important reading
   * @param level the level at which it's unlocked
   * @param unlockedDate the date at which it was unlocked
   * @param percentage the percentage the item has been reviewed correctly
   */
  public Kanji(String type, String character, 
          String[] meaning, String onyomi, 
          String[] kunyomi, String nanori, 
          String importantReading, int level) {
    super(type, character, meaning, level);
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