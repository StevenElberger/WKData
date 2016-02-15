package com.steve.wkdata;

/**
 * Mocks the WaniKani's API and returns example responses.
 * @author Steve
 */
public class MockService {
  private static final String USER_INFO = "{\"user_information\": {\"username\": \"BSheep\",\"gravatar\": \"627b24ac9fdb1ad6e01c141f80a591f7\",\"level\": 22,\"title\": \"Turtles\",\"about\": \"\",\"website\": null,\"twitter\": null,\"topics_count\": 0,\"posts_count\": 0,\"creation_date\": 1388623423,\"vacation_date\": null},\"requested_information\": null}";
  private static final String STUDY_QUEUE = "{\"user_information\": {\"username\": \"BSheep\",\"gravatar\": \"627b24ac9fdb1ad6e01c141f80a591f7\",\"level\": 22,\"title\": \"Turtles\",\"about\": \"\",\"website\": null,\"twitter\": null,\"topics_count\": 0,\"posts_count\": 0,\"creation_date\": 1388623423,\"vacation_date\": null},\"requested_information\": {\"lessons_available\": 0,\"reviews_available\": 136,\"next_review_date\": 1455418450,\"reviews_available_next_hour\": 47,\"reviews_available_next_day\": 235}}";
  private static final String LEVEL_PROGRESSION = "{\"user_information\": {\"username\": \"BSheep\",\"gravatar\": \"627b24ac9fdb1ad6e01c141f80a591f7\",\"level\": 22,\"title\": \"Turtles\",\"about\": \"\",\"website\": null,\"twitter\": null,\"topics_count\": 0,\"posts_count\": 0,\"creation_date\": 1388623423,\"vacation_date\": null},\"requested_information\": {\"radicals_progress\": 6,\"radicals_total\": 6,\"kanji_progress\": 6,\"kanji_total\": 31}}";
  private static final String SRS_DISTRIBUTION = "{\"user_information\": {\"username\": \"BSheep\",\"gravatar\": \"627b24ac9fdb1ad6e01c141f80a591f7\",\"level\": 22,\"title\": \"Turtles\",\"about\": \"\",\"website\": null,\"twitter\": null,\"topics_count\": 0,\"posts_count\": 0,\"creation_date\": 1388623423,\"vacation_date\": null},\"requested_information\": {\"apprentice\": {\"radicals\": 1,\"kanji\": 38,\"vocabulary\": 117,\"total\": 156},\"guru\": {\"radicals\": 30,\"kanji\": 113,\"vocabulary\": 489,\"total\": 632},\"master\": {\"radicals\": 21,\"kanji\": 94,\"vocabulary\": 273,\"total\": 388},\"enlighten\": {\"radicals\": 17,\"kanji\": 63,\"vocabulary\": 286,\"total\": 366},\"burned\": {\"radicals\": 259,\"kanji\": 439,\"vocabulary\": 1169,\"total\": 1867}}}";

  public static String getUserInformation() {
    return USER_INFO;
  }

  public static String getStudyQueue() {
    return STUDY_QUEUE;
  }

  public static String getLevelProgression() {
    return LEVEL_PROGRESSION;
  }

  public static String getSRSDistribution() {
    return SRS_DISTRIBUTION;
  }
}