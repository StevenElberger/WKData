package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A representation of the user's SRS distribution.
 * @author Steve
 */
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