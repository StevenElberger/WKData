package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A representation of a response from the WaniKani API.
 * Will always contain 'user_information', 'requested_information' may be null.
 * May also contain an error object instead.
 * @author Steve
 */
@JsonDeserialize(using = WaniKaniResponseDeserializer.class)
public class WaniKaniResponse {
  /**
   * The URL to request user's user information.
   */
  private HttpUrl userInformationURL;
  /**
   * The URL to request the user's study queue.
   */
  private HttpUrl studyQueueURL;
  /**
   * The URL to request the user's level progression.
   */
  private HttpUrl levelProgressionURL;
  /**
   * The URL to request the user's SRS distribution.
   */
  private HttpUrl srsDistributionURL;
  /**
   * A request for the user's user information.
   */
  private Request userInformationRequest;
  /**
   * A request for the user's study queue.
   */
  private Request studyQueueRequest;
  /**
   * A request for the user's level progression.
   */
  private Request levelProgressionRequest;
  /**
   * A request for the user's SRS distribution.
   */
  private Request srsDistributionRequest;
  /**
   * The client to handle the calls.
   */
  private OkHttpClient client;
  /**
   * A generic response object for all calls.
   */
  private Response response;
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

  /**
   * Going to be the true constructor soon.
   * @param key the API key for this user
   */
  public WaniKaniResponse(String key) {
    this.key = key;
    userInformationURL = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(key)
            .build();
    studyQueueURL = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(key)
            .addPathSegment("study-queue")
            .build();
    levelProgressionURL = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(key)
            .addPathSegment("level-progression")
            .build();
    srsDistributionURL = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(key)
            .addPathSegment("srs-distribution")
            .build();
    userInformationRequest = new Request.Builder()
            .url(userInformationURL)
            .build();
    studyQueueRequest = new Request.Builder()
            .url(studyQueueURL)
            .build();
    levelProgressionRequest = new Request.Builder()
            .url(levelProgressionURL)
            .build();
    srsDistributionRequest = new Request.Builder()
            .url(srsDistributionURL)
            .build();
    client = new OkHttpClient();
  }

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

  public String getKey() {
    return key;
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