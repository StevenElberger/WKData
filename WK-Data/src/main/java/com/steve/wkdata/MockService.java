package com.steve.wkdata;

public class MockService {
  private static final String USER_INFO = "{\"user_information\": {\"username\": \"BSheep\",\"gravatar\": \"627b24ac9fdb1ad6e01c141f80a591f7\",\"level\": 22,\"title\": \"Turtles\",\"about\": \"\",\"website\": null,\"twitter\": null,\"topics_count\": 0,\"posts_count\": 0,\"creation_date\": 1388623423,\"vacation_date\": null},\"requested_information\": null}";
  private static final String STUDY_QUEUE = "{\"user_information\": {\"username\": \"BSheep\",\"gravatar\": \"627b24ac9fdb1ad6e01c141f80a591f7\",\"level\": 22,\"title\": \"Turtles\",\"about\": \"\",\"website\": null,\"twitter\": null,\"topics_count\": 0,\"posts_count\": 0,\"creation_date\": 1388623423,\"vacation_date\": null},\"requested_information\": {\"lessons_available\": 0,\"reviews_available\": 136,\"next_review_date\": 1455418450,\"reviews_available_next_hour\": 47,\"reviews_available_next_day\": 235}}";

  public static String getUserInformation() {
    return USER_INFO;
  }

  public static String getStudyQueue() {
      return STUDY_QUEUE;
  }
}
