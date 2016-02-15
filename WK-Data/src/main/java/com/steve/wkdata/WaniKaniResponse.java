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
   * An object containing the user's information.
   */
  @JsonProperty("user_information")
  private UserInformation userInformation;
  /**
   * An object containing the user's study queue.
   */
  @JsonProperty("study_queue")
  private StudyQueue studyQueue;

  public WaniKaniResponse(UserInformation userInformation) {
      this.userInformation = userInformation;
  }

  public WaniKaniResponse(UserInformation userInformation, StudyQueue studyQueue) {
      this.userInformation = userInformation;
      this.studyQueue = studyQueue;
  }

  /**
   * Gets the user information object.
   * @return the user information object
   */
  public UserInformation getUserInformation() {
    return userInformation;
  }

  /**
   * Gets the user's study queue.
   * @return the user's study queue
   */
  public StudyQueue getStudyQueue() {
      return studyQueue;
  }
}
