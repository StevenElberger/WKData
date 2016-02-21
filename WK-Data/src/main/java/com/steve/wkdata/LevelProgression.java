package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A representation of the user's level progression.
 * @author Steve
 */
@JsonDeserialize(using = LevelProgressionDeserializer.class)
public class LevelProgression {
  /**
   * The user's progress through the current level's radicals.
   */
  @JsonProperty("radicals_progress")
  private int radicalsProgress;
  /**
   * The current level's total number of radicals.
   */
  @JsonProperty("radicals_total")
  private int radicalsTotal;
  /**
   * The user's progress through the current level's kanji.
   */
  @JsonProperty("kanji_progress")
  private int kanjiProgress;
  /**
   * The current level's total number of kanji.
   */
  @JsonProperty("kanji_total")
  private int kanjiTotal;

  /**
   * Constructor.
   * @param radicalsProgress the num of radicals in progress
   * @param radicalsTotal the num of radicals total
   * @param kanjiProgress the num of kanji in progress
   * @param kanjiTotal the num of kanji in total
   */
  public LevelProgression(int radicalsProgress, int radicalsTotal, 
                              int kanjiProgress, int kanjiTotal) {
    this.radicalsProgress = radicalsProgress;
    this.radicalsTotal = radicalsTotal;
    this.kanjiProgress = kanjiProgress;
    this.kanjiTotal = kanjiTotal;
  }

  public int getRadicalsProgress() {
    return radicalsProgress;
  }

  public int getRadicalsTotal() {
    return radicalsTotal;
  }

  public int getKanjiProgress() {
    return kanjiProgress;
  }

  public int getKanjiTotal() {
    return kanjiTotal;
  }
}