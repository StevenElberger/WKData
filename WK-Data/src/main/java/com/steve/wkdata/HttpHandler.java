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
   * Error string when failing to map to an object.
   */
  private static final String PROBLEM_PARSING = "Problem parsing data back from API";
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
   * Path segment for critical items call.
   */
  private static final String CRITICAL_ITEMS_STRING = "critical-items";
  /**
   * Base URL used in constructing other URLs.
   */
  private static final HttpUrl BASE_URL = HttpUrl.parse("https://www.wanikani.com/api/user/");
  /**
   * The URL to request user's user information.
   */
  private HttpUrl userInformationUrl;
  /**
   * The client to handle the calls.
   */
  private OkHttpClient client;

  /**
   * Constructor.
   * @param key the user's API key
   */
  public HttpHandler(String key) {
    userInformationUrl = BASE_URL.newBuilder()
            .addPathSegment(key)
            .build();
    client = new OkHttpClient();
  }

  /**
   * Makes a call for the given type of data, returns
   * the response.
   * @param type the type of data (e.g., user info, etc.)
   * @return the response from the API (may be {@code null})
   */
  private Response makeCall(String type) {
    return makeCall(type, -1);
  }

  /**
   * Used to make a call to the API and return
   * the response. A limit of -1 will make the call without
   * a limit. The acceptable ranges of limit are otherwise 0-100.
   * @param type the type of data (e.g., user info, etc.)
   * @param limit the limit to specify, if any.
   * @return the response from the API (may be {@code null})
   */
  private Response makeCall(String type, int limit) {
    Response response = null;
    HttpUrl url = userInformationUrl;
    if (!type.equals("")) { // empty string for user info
      url = url.newBuilder()
              .addPathSegment(type)
              .build();
    }
    if (limit != -1) {
      url = url.newBuilder()
              .addPathSegment(String.valueOf(limit))
              .build();
    }
    Request request = new Request.Builder()
                .url(url)
                .build();
    try {
      response = client.newCall(request).execute();
    } catch (IOException e) {
      System.out.println("Error reaching API...");
    }
    return response;
  }

  /**
   * Makes a call to the API to get the user's user information.
   * @return user information (may be {@code null} if failure)
   */
  public UserInformation getUserInformation() {
    UserInformation userInformation = null;
    Response response = makeCall("");
    if (response != null && response.isSuccessful()) {
      ObjectMapper mapper = new ObjectMapper();
      try {
        userInformation = mapper.readValue(response.body().string(), UserInformation.class);
      } catch (Exception e) {
        System.out.println(PROBLEM_PARSING);
      }
    }
    return userInformation;
  }

  /**
   * Makes a call to the API to get the user's study queue.
   * @return study queue (may be {@code null} if failure)
   */
  public StudyQueue getStudyQueue() {
    StudyQueue studyQueue = null;
    Response response = makeCall(STUDY_QUEUE_STRING);
    if (response != null && response.isSuccessful()) {
      ObjectMapper mapper = new ObjectMapper();
      try {
        studyQueue = mapper.readValue(response.body().string(), StudyQueue.class);
      } catch (Exception e) {
        System.out.println(PROBLEM_PARSING);
      }
    }
    return studyQueue;
  }

  /**
   * Makes a call to the API to get the user's level progression.
   * @return level progression (may be {@code null} if failure)
   */
  public LevelProgression getLevelProgression() {
    LevelProgression levelProgression = null;
    Response response = makeCall(LEVEL_PROGRESSION_STRING);
    if (response != null && response.isSuccessful()) {
      ObjectMapper mapper = new ObjectMapper();
      try {
        levelProgression = mapper.readValue(response.body().string(), LevelProgression.class);
      } catch (Exception e) {
        System.out.println(PROBLEM_PARSING);
      }
    }
    return levelProgression;
  }

  /**
   * Makes a call to the API to get the user's srs distribution.
   * @return srs distribution (may be {@code null} if failure)
   */
  public SrsDistribution getSrsDistribution() {
    SrsDistribution srsDistribution = null;
    Response response = makeCall(SRS_DISTRIBUTION_STRING);
    if (response != null && response.isSuccessful()) {
      ObjectMapper mapper = new ObjectMapper();
      try {
        srsDistribution = mapper.readValue(response.body().string(), SrsDistribution.class);
      } catch (Exception e) {
        System.out.println(PROBLEM_PARSING);
      }
    }
    return srsDistribution;
  }

  /**
   * Makes a call to the API to get the user's recent unlocks list.
   * @return recent unlocks list (may be {@code null} if failure)
   */
  public RecentUnlocksList getRecentUnlocksList() {
    return getRecentUnlocksList(-1);
  }

  /**
   * Makes a call to the API to get the user's recent unlocks list.
   * Specified limit must be between 1 and 100.
   * @return recent unlocks list (may be {@code null} if failure)
   */
  public RecentUnlocksList getRecentUnlocksList(int limit) {
      RecentUnlocksList recentUnlocksList = null;
    // fail if limit was bad
    if ((limit < 0 && limit != -1) || limit > 100) {
      return null;
    }
    Response response;
    if (limit == -1) {
      response = makeCall(RECENT_UNLOCKS_STRING);
    } else {
      response = makeCall(RECENT_UNLOCKS_STRING, limit);
    }
    if (response != null && response.isSuccessful()) {
      ObjectMapper mapper = new ObjectMapper();
      try {
        recentUnlocksList = mapper.readValue(response.body().string(), RecentUnlocksList.class);
      } catch (Exception e) {
        System.out.println(PROBLEM_PARSING);
      }
    }
    return recentUnlocksList;
  }

  /**
   * Makes a call to the API to get the user's critical items list.
   * @return critical items list (may be {@code null} if failure)
   */
  public CriticalItemsList getCriticalItemsList() {
    return getCriticalItemsList(-1);
  }

  /**
   * Makes a call to the API to get the user's critical items list.
   * Specified limit must be between 0 and 100.
   * @return critical items list (may be {@code null} if failure)
   */
  public CriticalItemsList getCriticalItemsList(int limit) {
    CriticalItemsList criticalItemsList = null;
    // fail if limit was bad
    if ((limit < 0 && limit != -1) || limit > 100) {
      return null;
    }
    Response response;
    if (limit == -1) {
      response = makeCall(CRITICAL_ITEMS_STRING);
    } else {
      response = makeCall(CRITICAL_ITEMS_STRING, limit);
    }
    if (response != null && response.isSuccessful()) {
      ObjectMapper mapper = new ObjectMapper();
      try {
        criticalItemsList = mapper.readValue(response.body().string(), CriticalItemsList.class);
      } catch (Exception e) {
        System.out.println(PROBLEM_PARSING);
      }
    }
    return criticalItemsList;
  }
}