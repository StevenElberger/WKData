package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A representation of the user's SRS distribution.
 * @author Steve
 */
@JsonDeserialize(using = SRSDistributionDeserializer.class)
public class SRSDistribution {
  /**
   * The apprentice-level srs item.
   */
  @JsonProperty("apprentice")
  private SRSItem apprentice;
  /**
   * The guru-level srs item.
   */
  @JsonProperty("guru")
  private SRSItem guru;
  /**
   * The master-level srs item.
   */
  @JsonProperty("master")
  private SRSItem master;
  /**
   * The enlighten-level srs item.
   */
  @JsonProperty("enlighten")
  private SRSItem enlighten;
  /**
   * The burned-level srs item
   */
  @JsonProperty("burned")
  private SRSItem burned;

  public SRSDistribution(SRSItem apprentice, SRSItem guru, 
          SRSItem master, SRSItem enlighten, SRSItem burned) {
    this.apprentice = apprentice;
    this.guru = guru;
    this.master = master;
    this.enlighten = enlighten;
    this.burned = burned;
  }

  /**
   * @return the apprentice
   */
  public SRSItem getApprentice() {
    return apprentice;
  }

  /**
   * @return the guru
   */
  public SRSItem getGuru() {
    return guru;
  }

  /**
   * @return the master
   */
  public SRSItem getMaster() {
    return master;
  }

  /**
   * @return the enlighten
   */
  public SRSItem getEnlighten() {
    return enlighten;
  }

  /**
   * @return the burned
   */
  public SRSItem getBurned() {
    return burned;
  }

/**
   * A representation of an SRS item.
   * @author Steve
   */
  public class SRSItem {
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

    public SRSItem(int radicals, int kanji, int vocabulary, int total) {
      this.radicals = radicals;
      this.kanji = kanji;
      this.vocabulary = vocabulary;
      this.total = total;
    }
    /**
     * @return the radicals
     */
    public int getRadicals() {
        return radicals;
    }

    /**
     * @return the kanji
     */
    public int getKanji() {
        return kanji;
    }

    /**
     * @return the vocabulary
     */
    public int getVocabulary() {
        return vocabulary;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }
  }
}