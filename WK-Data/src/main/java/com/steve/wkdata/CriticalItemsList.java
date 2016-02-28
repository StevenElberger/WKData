package com.steve.wkdata;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CriticalItemsListDeserializer.class)
public class CriticalItemsList extends ItemsList {

  public CriticalItemsList(ArrayList<Item> list, long lastRefreshed) {
    super(list, lastRefreshed);
  }

  /**
   * Class for critical items list vocabulary items which
   * includes a percentage.
   * @author Steve
   */
  public static class CriticalVocabulary extends Vocabulary {
    /**
     * Percentage of attempts correct.
     */
    private int percentage;

    public CriticalVocabulary(String type, String character, 
            String kana, String[] meaning, int level, int percentage) {
      super(type, character, kana, meaning, level);
      this.percentage = percentage;
    }

    public int getPercentage() {
      return percentage;
    }
  }

  /**
   * Class for critical items list radicals items which
   * includes a percentage.
   * @author Steve
   */
  public static class CriticalRadical extends Radical {
    /**
     * Percentage of attempts correct.
     */
    private int percentage;

    public CriticalRadical(String type, String character, 
            String[] meaning, String image, int level, int percentage) {
      super(type, character, meaning, image, level);
      this.percentage = percentage;
    }

    public int getPercentage() {
      return percentage;
    }
  }

  /**
   * Class for critical items list kanji items which
   * includes a percentage.
   * @author Steve
   */
  public static class CriticalKanji extends Kanji {
    /**
     * Percentage of attempts correct.
     */
    private int percentage;

    public CriticalKanji(String type, String character, 
            String[] meaning, String onyomi, String[] kunyomi,
            String nanori, String importantReading, int level, int percentage) {
      super(type, character, meaning, onyomi, kunyomi, nanori, importantReading, level);
      this.percentage = percentage;
    }

    public int getPercentage() {
      return percentage;
    }
  }
}
