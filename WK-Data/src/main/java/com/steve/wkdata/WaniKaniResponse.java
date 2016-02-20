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
   * An array to hold the timestamps of the last time
   * each object was refreshed (data caching purposes).
   */
  private long[] callTimestamps = {0, 0, 0, 0};
  /**
   * The user's API key.
   */
  private String key;
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

  public long[] getCallTimestamps() {
    return callTimestamps;
  }

  public void setCallTimestamps(long[] callTimestamps) {
    this.callTimestamps = callTimestamps;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public UserInformation getUserInformation() {
    return userInformation;
  }

  public void setUserInformation(UserInformation userInformation) {
    this.userInformation = userInformation;
  }

  public StudyQueue getStudyQueue() {
    return studyQueue;
  }

  public void setStudyQueue(StudyQueue studyQueue) {
    this.studyQueue = studyQueue;
  }

  public LevelProgression getLevelProgression() {
    return levelProgression;
  }

  public void setLevelProgression(LevelProgression levelProgression) {
    this.levelProgression = levelProgression;
  }

  public SRSDistribution getSRSDistribution() {
    return srsDistribution;
  }

  public void setSRSDistribution(SRSDistribution srsDistribution) {
    this.srsDistribution = srsDistribution;
  }
}