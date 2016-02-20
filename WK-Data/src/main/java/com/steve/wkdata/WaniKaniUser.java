package com.steve.wkdata;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class WaniKaniUser {
  private static final long THIRTY_MINUTES = 30 * 60 * 1000;
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
  public WaniKaniUser(String key) {
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

  public String getKey() {
    return key;
  }

  public long[] getCallTimestamps() {
    return callTimestamps;
  }

  public UserInformation getUserInformation() throws IOException {
    if (userInformation == null || (userInformation != null && 
            System.currentTimeMillis() - THIRTY_MINUTES >= callTimestamps[0])) {
      response = client.newCall(userInformationRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        userInformation = mapper.readValue(response.body().string(), UserInformation.class);
        callTimestamps[0] = System.currentTimeMillis();
      }
    }
    return userInformation;
  }

  public StudyQueue getStudyQueue() throws IOException {
    if (studyQueue == null || (studyQueue != null && 
            System.currentTimeMillis() - THIRTY_MINUTES >= callTimestamps[1])) {
      response = client.newCall(studyQueueRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        studyQueue = mapper.readValue(response.body().string(), StudyQueue.class);
        callTimestamps[1] = System.currentTimeMillis();
      }
    }
    return studyQueue;
  }

  public LevelProgression getLevelProgression() throws IOException {
    if (levelProgression == null || (levelProgression != null && 
            System.currentTimeMillis() - THIRTY_MINUTES >= callTimestamps[2])) {
      response = client.newCall(levelProgressionRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        levelProgression = mapper.readValue(response.body().string(), LevelProgression.class);
        callTimestamps[2] = System.currentTimeMillis();
      }
    }
    return levelProgression;
  }

  public SRSDistribution getSRSDistribution() throws IOException {
    if (srsDistribution == null || (srsDistribution != null && 
            System.currentTimeMillis() - THIRTY_MINUTES >= callTimestamps[3])) {
      response = client.newCall(srsDistributionRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        srsDistribution = mapper.readValue(response.body().string(), SRSDistribution.class);
        callTimestamps[3] = System.currentTimeMillis();
      }
    }
    return srsDistribution;
  }
}