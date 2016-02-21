package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A representation of the user's SRS distribution.
 * @author Steve
 */
@JsonDeserialize(using = SrsDistributionDeserializer.class)
public class SrsDistribution {
  /**
   * The expiration time limit for this object. Set to 1 hour.
   */
  private static final long EXPIRATION_TIME = 60 * 60 * 1000;
  /**
   * The timestamp of the last time this object was refreshed with new data.
   */
  private long lastRefreshed = 0;
  /**
   * The apprentice-level srs item.
   */
  @JsonProperty("apprentice")
  private SrsItem apprentice;
  /**
   * The guru-level srs item.
   */
  @JsonProperty("guru")
  private SrsItem guru;
  /**
   * The master-level srs item.
   */
  @JsonProperty("master")
  private SrsItem master;
  /**
   * The enlighten-level srs item.
   */
  @JsonProperty("enlighten")
  private SrsItem enlighten;
  /**
   * The burned-level srs item.
   */
  @JsonProperty("burned")
  private SrsItem burned;

  /**
   * Constructor.
   * @param lastRefreshed the time this object was constructed (expiration purposes)
   */
  public SrsDistribution(long lastRefreshed) {
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

  public SrsItem getApprentice() {
    return apprentice;
  }

  public void setApprentice(SrsItem apprentice) {
    this.apprentice = apprentice;
  }

  public SrsItem getGuru() {
    return guru;
  }

  public void setGuru(SrsItem guru) {
    this.guru = guru;
  }

  public SrsItem getMaster() {
    return master;
  }

  public void setMaster(SrsItem master) {
    this.master = master;
  }

  public SrsItem getEnlighten() {
    return enlighten;
  }

  public void setEnlighten(SrsItem enlighten) {
    this.enlighten = enlighten;
  }

  public SrsItem getBurned() {
    return burned;
  }

  public void setBurned(SrsItem burned) {
    this.burned = burned;
  }

  /**
   * A representation of an SRS item.
   * @author Steve
   */
  public class SrsItem {
    /**
     * The number of radicals.
     */
    @JsonProperty("radicals")
    private int radicals;
    /**
     * The number of kanji.
     */
    @JsonProperty("kanji")
    private int kanji;
    /**
     * The number of vocabulary words.
     */
    @JsonProperty("vocabulary")
    private int vocabulary;
    /**
     * The total number of items.
     */
    @JsonProperty("total")
    private int total;

    /**
     * Constructor.
     * @param radicals the num of radicals
     * @param kanji the num of kanji
     * @param vocabulary the num of vocabulary
     * @param total the num total
     */
    public SrsItem(int radicals, int kanji, int vocabulary, int total) {
      this.radicals = radicals;
      this.kanji = kanji;
      this.vocabulary = vocabulary;
      this.total = total;
    }

    public int getRadicals() {
      return radicals;
    }

    public int getKanji() {
      return kanji;
    }

    public int getVocabulary() {
      return vocabulary;
    }

    public int getTotal() {
      return total;
    }
  }
}