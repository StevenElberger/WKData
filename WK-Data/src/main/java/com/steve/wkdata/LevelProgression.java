package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A representation of the user's level progression.
 * @author Steve
 */
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
   * @return the radicalsProgress
   */
  public int getRadicalsProgress() {
    return radicalsProgress;
  }

  /**
   * @return the radicalsTotal
   */
  public int getRadicalsTotal() {
    return radicalsTotal;
  }

  /**
   * @return the kanjiProgress
   */
  public int getKanjiProgress() {
    return kanjiProgress;
  }

  /**
   * @return the kanjiTotal
   */
  public int getKanjiTotal() {
    return kanjiTotal;
  }
}