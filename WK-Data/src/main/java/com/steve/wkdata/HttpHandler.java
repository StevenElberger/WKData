package com.steve.wkdata;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Handles all calls to the API.
 * @author Steve
 */
public class HttpHandler {
  /**
   * The scheme for each call.
   */
  private static final String SCHEME = "https";
  /**
   * The host for each call.
   */
  private static final String HOST = "www.wanikani.com";
  /**
   * Path segment for each call.
   */
  private static final String API_STRING = "api";
  /**
   * Path segment for each call.
   */
  private static final String USER_STRING = "user";
  /**
   * Path segment for study queue call.
   */
  private static final String STUDY_QUEUE_STRING = "study-queue";
  /**
   * Path segment for level progression call.
   */
  private static final String LEVEL_PROGRESSION_STRING = "level-progression";
  /**
   * Path segment for SRS distribution call.
   */
  private static final String SRS_DISTRIBUTION_STRING = "srs-distribution";
  /**
   * Path segment for recent unlocks call.
   */
  private static final String RECENT_UNLOCKS_STRING = "recent-unlocks";
  /**
   * The URL to request user's user information.
   */
  private HttpUrl userInformationUrl;
  /**
   * The URL to request the user's study queue.
   */
  private HttpUrl studyQueueUrl;
  /**
   * The URL to request the user's level progression.
   */
  private HttpUrl levelProgressionUrl;
  /**
   * The URL to request the user's SRS distribution.
   */
  private HttpUrl srsDistributionUrl;
  /**
   * The URL to request the user's recent unlocks list.
   */
  private HttpUrl recentUnlocksListUrl;
  /**
   * The URL to request the user's recent unlocks list with a limit.
   */
  private HttpUrl recentUnlocksListWithLimitUrl;
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
   * A request for the user's recent unlocks list.
   */
  private Request recentUnlocksListRequest;
  /**
   * A request for the user's recent unlocks list with a limit.
   */
  private Request recentUnlocksListRequestWithLimit;
  /**
   * The client to handle the calls.
   */
  private OkHttpClient client;
  /**
   * A generic response object for all calls.
   */
  private Response response;

  /**
   * Constructor.
   * @param key the user's API key
   */
  public HttpHandler(String key) {
    userInformationUrl = new HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegment(API_STRING)
            .addPathSegment(USER_STRING)
            .addPathSegment(key)
            .build();
    studyQueueUrl = new HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegment(API_STRING)
            .addPathSegment(USER_STRING)
            .addPathSegment(key)
            .addPathSegment(STUDY_QUEUE_STRING)
            .build();
    levelProgressionUrl = new HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegment(API_STRING)
            .addPathSegment(USER_STRING)
            .addPathSegment(key)
            .addPathSegment(LEVEL_PROGRESSION_STRING)
            .build();
    srsDistributionUrl = new HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegment(API_STRING)
            .addPathSegment(USER_STRING)
            .addPathSegment(key)
            .addPathSegment(SRS_DISTRIBUTION_STRING)
            .build();
    recentUnlocksListUrl = new HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegment(API_STRING)
            .addPathSegment(USER_STRING)
            .addPathSegment(key)
            .addPathSegment(RECENT_UNLOCKS_STRING)
            .build();
    userInformationRequest = new Request.Builder()
            .url(userInformationUrl)
            .build();
    studyQueueRequest = new Request.Builder()
            .url(studyQueueUrl)
            .build();
    levelProgressionRequest = new Request.Builder()
            .url(levelProgressionUrl)
            .build();
    srsDistributionRequest = new Request.Builder()
            .url(srsDistributionUrl)
            .build();
    recentUnlocksListRequest = new Request.Builder()
            .url(recentUnlocksListUrl)
            .build();
    client = new OkHttpClient();
  }

  /**
   * Makes a call to the API to get the user's user information.
   * @return user information (may be {@code null} if failure)
   */
  public UserInformation getUserInformation() {
    UserInformation userInformation = null;
    try {
      response = client.newCall(userInformationRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        userInformation = mapper.readValue(response.body().string(), UserInformation.class);
      }
    } catch (IOException e) {
      System.out.println("Error getting user information");
    }
    return userInformation;
  }

  /**
   * Makes a call to the API to get the user's study queue.
   * @return study queue (may be {@code null} if failure)
   */
  public StudyQueue getStudyQueue() {
    StudyQueue studyQueue = null;
    try {
      response = client.newCall(studyQueueRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        studyQueue = mapper.readValue(response.body().string(), StudyQueue.class);
      }
    } catch (IOException e) {
      System.out.println("Error getting study queue");
    }
    return studyQueue;
  }

  /**
   * Makes a call to the API to get the user's level progression.
   * @return level progression (may be {@code null} if failure)
   */
  public LevelProgression getLevelProgression() {
    LevelProgression levelProgression = null;
    try {
      response = client.newCall(levelProgressionRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        levelProgression = mapper.readValue(response.body().string(), LevelProgression.class);
      }
    } catch (IOException e) {
      System.out.println("Error getting level progression");
    }
    return levelProgression;
  }

  /**
   * Makes a call to the API to get the user's srs distribution.
   * @return srs distribution (may be {@code null} if failure)
   */
  public SrsDistribution getSrsDistribution() {
    SrsDistribution srsDistribution = null;
    try {
      response = client.newCall(srsDistributionRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        srsDistribution = mapper.readValue(response.body().string(), SrsDistribution.class);
      }
    } catch (IOException e) {
      System.out.println("Error getting srs distribution");
    }
    
    return srsDistribution;
  }

  /**
   * Makes a call to the API to get the user's recent unlocks list.
   * @return recent unlocks list (may be {@code null} if failure)
   */
  public RecentUnlocksList getRecentUnlocksList() {
    RecentUnlocksList recentUnlocksList = null;
    try {
      response = client.newCall(recentUnlocksListRequest).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        recentUnlocksList = mapper.readValue(response.body().string(), RecentUnlocksList.class);
      }
    } catch (IOException e) {
      System.out.println("Error getting srs distribution");
    }
    
    return recentUnlocksList;
  }

  /**
   * Makes a call to the API to get the user's recent unlocks list.
   * Specified limit must be between 1 and 100.
   * @return recent unlocks list (may be {@code null} if failure)
   */
  public RecentUnlocksList getRecentUnlocksList(int limit, String key) {
    RecentUnlocksList recentUnlocksList = null;
    // fail if limit was bad
    if (limit < 1 || limit > 100) {
      return null;
    }
    // have to construct a new URL with the new limit
    recentUnlocksListWithLimitUrl = new HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegment(API_STRING)
            .addPathSegment(USER_STRING)
            .addPathSegment(key)
            .addPathSegment(RECENT_UNLOCKS_STRING)
            .addPathSegment(String.valueOf(limit))
            .build();
    if (recentUnlocksListRequestWithLimit == null) {
      recentUnlocksListRequestWithLimit = new Request.Builder()
            .url(recentUnlocksListWithLimitUrl)
            .build();
    }
    try {
      response = client.newCall(recentUnlocksListRequestWithLimit).execute();
      if (response.isSuccessful()) {
        ObjectMapper mapper = new ObjectMapper();
        recentUnlocksList = mapper.readValue(response.body().string(), RecentUnlocksList.class);
      }
    } catch (IOException e) {
      System.out.println("Error getting srs distribution");
    }

    return recentUnlocksList;
  }
}