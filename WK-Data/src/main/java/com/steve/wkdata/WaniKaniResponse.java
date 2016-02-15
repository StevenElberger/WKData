package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A representation of a response from the WaniKani API.
 * Will always contain 'user_information', 'requested_information' may be null.
 * May also contain an error object instead.
 * @author Steve
 */
@JsonDeserialize(using = WaniKaniResponseDeserializer.class)
public class WaniKaniResponse {
  /**
   * An object containing the user's information.
   */
  @JsonProperty("user_information")
  private UserInformation userInformation;
  /**
   * An object containing the user's study queue.
   */
  @JsonProperty("study_queue")
  private StudyQueue studyQueue;
  /**
   * An object containing the user's level progression.
   */
  @JsonProperty("level_progression")
  private LevelProgression levelProgression;
  /**
   * An object containing the user's SRS distribution.
   */
  @JsonProperty("srs_distribution")
  private SRSDistribution srsDistribution;

  public WaniKaniResponse(UserInformation userInformation) {
    this.userInformation = userInformation;
  }

  public WaniKaniResponse(UserInformation userInformation, StudyQueue studyQueue) {
    this.userInformation = userInformation;
    this.studyQueue = studyQueue;
  }

  public WaniKaniResponse(UserInformation userInformation, LevelProgression levelProgression) {
    this.userInformation = userInformation;
    this.levelProgression = levelProgression;
  }

  public WaniKaniResponse(UserInformation userInformation, SRSDistribution srsDistribution) {
    this.userInformation = userInformation;
    this.srsDistribution = srsDistribution;
  }

  /**
   * @return the user information object
   */
  public UserInformation getUserInformation() {
    return userInformation;
  }

  /**
   * @return the user's study queue
   */
  public StudyQueue getStudyQueue() {
    return studyQueue;
  }

  /**
   * @return the user's level progression
   */
  public LevelProgression getLevelProgression() {
    return levelProgression;
  }

  /**
   * @return the user's SRS distribution
   */
  public SRSDistribution getSRSDistribution() {
    return srsDistribution;
  }
}