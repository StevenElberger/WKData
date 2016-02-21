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
   * Constructor.
   * @param key the user's API key
   */
  public HttpHandler(String key) {
    userInformationUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(key)
            .build();
    studyQueueUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(key)
            .addPathSegment("study-queue")
            .build();
    levelProgressionUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(key)
            .addPathSegment("level-progression")
            .build();
    srsDistributionUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(key)
            .addPathSegment("srs-distribution")
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
}
