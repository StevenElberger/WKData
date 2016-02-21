package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A representation of a response from the WaniKani API.
 * Will always contain 'user_information', 'requested_information' may be null.
 * May also contain an error object instead.
 * @author Steve
 */
public class WaniKaniUser {
  /**
   * The HttpHandler object which makes calls to the API.
   */
  HttpHandler httpHandler;
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
  private SrsDistribution srsDistribution;
  /**
   * An object containing the user's recent unlocks list.
   */
  @JsonProperty("recent_unlocks")
  private RecentUnlocksList recentUnlocksList;

  /**
   * Constructor.
   * @param key the API key for this user
   */
  public WaniKaniUser(String key) {
    this.key = key;
    httpHandler = new HttpHandler(key);
  }

  public String getKey() {
    return key;
  }

  /**
   * Retrieves the user's user information.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's user information (may be {@code null})
   */
  public UserInformation getUserInformation() {
    if (userInformation == null || (userInformation != null && userInformation.isExpired())) {
      UserInformation response = httpHandler.getUserInformation();
      // check for failure (return what we have already if failed)
      if (response != null) {
        userInformation = response;
      }
    }
    return userInformation;
  }

  /**
   * Retrieve's the user's study queue.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's study queue (may be {@code null})
   */
  public StudyQueue getStudyQueue() {
    if (studyQueue == null || (studyQueue != null && studyQueue.isExpired())) {
      StudyQueue response = httpHandler.getStudyQueue();
      // check for failure (return what we have already if failed)
      if (response != null) {
        studyQueue = response;
      }
    }
    return studyQueue;
  }

  /**
   * Retrieve's the user's level progression.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's level progression (may be {@code null})
   */
  public LevelProgression getLevelProgression() {
    if (levelProgression == null || (levelProgression != null && levelProgression.isExpired())) {
      LevelProgression response = httpHandler.getLevelProgression();
      // check for failure (return what we have already if failed)
      if (response != null) {
        levelProgression = response;
      }
    }
    return levelProgression;
  }

  /**
   * Retrieve's the user's SRS distribution.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's SRS distribution (may be {@code null})
   */
  public SrsDistribution getSrsDistribution() {
    if (srsDistribution == null || (srsDistribution != null && srsDistribution.isExpired())) {
      SrsDistribution response = httpHandler.getSrsDistribution();
      // check for failure (return what we have already if failed)
      if (response != null) {
        srsDistribution = response;
      }
    }
    return srsDistribution;
  }

  /**
   * Retrieve's the user's recent unlocks list.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's recent unlocks list (may be {@code null})
   */
  public RecentUnlocksList getRecentUnlocksList() {
    if (recentUnlocksList == null || (recentUnlocksList != null && recentUnlocksList.isExpired())) {
      RecentUnlocksList response = httpHandler.getRecentUnlocksList();
      // check for failure (return what we have already if failed)
      if (response != null) {
        recentUnlocksList = response;
      }
    }
    return recentUnlocksList;
  }

  /**
   * Retrieve's the user's recent unlocks list with a limit.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * Limit must be within 1 and 100.
   * @return the user's recent unlocks list (may be {@code null})
   */
  public RecentUnlocksList getRecentUnlocksList(int limit) {
    if (recentUnlocksList == null || (recentUnlocksList != null && recentUnlocksList.isExpired())) {
      RecentUnlocksList response = httpHandler.getRecentUnlocksList(limit, key);
      // check for failure (return what we have already if failed)
      if (response != null) {
        recentUnlocksList = response;
      }
    }
    return recentUnlocksList;
  }
}