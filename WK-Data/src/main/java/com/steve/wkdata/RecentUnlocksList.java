package com.steve.wkdata;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = RecentUnlocksListDeserializer.class)
public class RecentUnlocksList extends ItemsList {

  public RecentUnlocksList(ArrayList<Item> list, long lastRefreshed) {
    super(list, lastRefreshed);
  }

  /**
   * Class for recent unlock list vocabulary items which
   * includes an unlock date.
   * @author Steve
   */
  public static class RecentUnlockVocabulary extends Vocabulary {
    /**
     * The date at which this item was unlocked.
     */
    private long unlockDate;

    public RecentUnlockVocabulary(String type, String character, 
            String kana, String[] meaning, int level, long unlockDate) {
      super(type, character, kana, meaning, level);
      this.unlockDate = unlockDate;
    }

    public long getUnlockDate() {
      return unlockDate;
    }
  }

  /**
   * Class for recent unlock list radical items which
   * includes an unlock date.
   * @author Steve
   */
  public static class RecentUnlockRadical extends Radical {
    /**
     * The date at which this item was unlocked.
     */
    private long unlockDate;

    public RecentUnlockRadical(String type, String character, 
            String[] meaning, String image, int level, long unlockDate) {
      super(type, character, meaning, image, level);
      this.unlockDate = unlockDate;
    }

    public long getUnlockDate() {
      return unlockDate;
    }
  }

  /**
   * Class for recent unlock list kanji items which
   * includes an unlock date.
   * @author Steve
   */
  public static class RecentUnlockKanji extends Kanji {
    /**
     * The date at which this item was unlocked.
     */
    private long unlockDate;

    public RecentUnlockKanji(String type, String character, 
            String[] meaning, String onyomi, String[] kunyomi, 
            String nanori, String importantReading, int level, long unlockDate) {
      super(type, character, meaning, onyomi, kunyomi, nanori, importantReading, level);
      this.unlockDate = unlockDate;
    }

    public long getUnlockDate() {
      return unlockDate;
    }
  }
}
