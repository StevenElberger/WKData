package com.steve.wkdata;

import java.util.Optional;

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
  private HttpHandler httpHandler;
  /**
   * The user's API key.
   */
  private String key;
  /**
   * An object containing the user's information.
   */
  @JsonProperty("user_information")
  private Optional<UserInformation> userInformation;
  /**
   * An object containing the user's study queue.
   */
  @JsonProperty("study_queue")
  private Optional<StudyQueue> studyQueue;
  /**
   * An object containing the user's level progression.
   */
  @JsonProperty("level_progression")
  private Optional<LevelProgression> levelProgression;
  /**
   * An object containing the user's SRS distribution.
   */
  @JsonProperty("srs_distribution")
  private Optional<SrsDistribution> srsDistribution;
  /**
   * An object containing the user's recent unlocks list.
   */
  @JsonProperty("recent_unlocks")
  private Optional<ItemsList> recentUnlocksList;
  /**
   * An object containing the user's critical items list.
   */
  @JsonProperty("critical_items")
  private Optional<ItemsList> criticalItemsList;

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
   * @return the user's user information
   */
  public Optional<UserInformation> getUserInformation() {
    if (!userInformation.isPresent() || userInformation.get().isExpired()) {
      userInformation = Optional.ofNullable(httpHandler.getUserInformation());
    }
    return userInformation;
  }

  /**
   * Retrieve's the user's study queue.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's study queue
   */
  public Optional<StudyQueue> getStudyQueue() {
    if (!studyQueue.isPresent() || studyQueue.get().isExpired()) {
      studyQueue = Optional.ofNullable(httpHandler.getStudyQueue());
    }
    return studyQueue;
  }

  /**
   * Retrieve's the user's level progression.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's level progression
   */
  public Optional<LevelProgression> getLevelProgression() {
    if (!levelProgression.isPresent() || levelProgression.get().isExpired()) {
      levelProgression = Optional.ofNullable(httpHandler.getLevelProgression());
    }
    return levelProgression;
  }

  /**
   * Retrieve's the user's SRS distribution.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's SRS distribution
   */
  public Optional<SrsDistribution> getSrsDistribution() {
    if (!srsDistribution.isPresent() || srsDistribution.get().isExpired()) {
      srsDistribution = Optional.ofNullable(httpHandler.getSrsDistribution());
    }
    return srsDistribution;
  }

  /**
   * Retrieve's the user's recent unlocks list.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's recent unlocks list
   */
  public Optional<ItemsList> getRecentUnlocksList() {
    return getRecentUnlocksList(-1);
  }

  /**
   * Retrieve's the user's recent unlocks list with a limit.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * Limit must be within 1 and 100.
   * @return the user's recent unlocks list
   */
  public Optional<ItemsList> getRecentUnlocksList(int limit) {
    if (!recentUnlocksList.isPresent() || recentUnlocksList.get().isExpired()) {
      if (limit == -1) {
        recentUnlocksList = Optional.ofNullable(httpHandler.getRecentUnlocksList());
      } else {
        recentUnlocksList = Optional.ofNullable(httpHandler.getRecentUnlocksList(limit));
      }
    }
    return recentUnlocksList;
  }

  /**
   * Retrieve's the user's recent unlocks list.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * @return the user's recent unlocks list
   */
  public Optional<ItemsList> getCriticalItemsList() {
    return getCriticalItemsList(-1);
  }

  /**
   * Retrieve's the user's recent unlocks list with a limit.
   * If the data is nonexistent or expired, the data
   * will be retrieved and returned from the API.
   * Limit must be within 1 and 100.
   * @return the user's recent unlocks list
   */
  public Optional<ItemsList> getCriticalItemsList(int limit) {
    if (!criticalItemsList.isPresent() || criticalItemsList.get().isExpired()) {
      if (limit == -1) {
        criticalItemsList = Optional.ofNullable(httpHandler.getCriticalItemsList());
      } else {
        criticalItemsList = Optional.ofNullable(httpHandler.getCriticalItemsList(limit));
      }
    }
    return recentUnlocksList;
  }
}