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

  public SRSItem getApprentice() {
    return apprentice;
  }

  public void setApprentice(SRSItem apprentice) {
    this.apprentice = apprentice;
  }

  public SRSItem getGuru() {
    return guru;
  }

  public void setGuru(SRSItem guru) {
    this.guru = guru;
  }

  public SRSItem getMaster() {
    return master;
  }

  public void setMaster(SRSItem master) {
    this.master = master;
  }

  public SRSItem getEnlighten() {
    return enlighten;
  }

  public void setEnlighten(SRSItem enlighten) {
    this.enlighten = enlighten;
  }

  public SRSItem getBurned() {
    return burned;
  }

  public void setBurned(SRSItem burned) {
    this.burned = burned;
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