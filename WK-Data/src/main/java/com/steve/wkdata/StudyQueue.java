package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A representation of a study queue object.
 * @author Steve
 */
@JsonDeserialize(using = StudyQueueDeserializer.class)
public class StudyQueue {
  /**
   * The number of lessons currently available.
   */
  @JsonProperty("lessons_available")
  private int lessonsAvailable;
  /**
   * The number of reviews currently available.
   */
  @JsonProperty("reviews_available")
  private int reviewsAvailable;
  /**
   * The time for when the next review will be available.
   */
  @JsonProperty("next_review_date")
  private long nextReviewDate;
  /**
   * The number of reviews available within the next hour.
   */
  @JsonProperty("reviews_available_next_hour")
  private int reviewsAvailableNextHour;
  /**
   * The number of reviews available within the next day.
   */
  @JsonProperty("reviews_available_next_day")
  private int reviewsAvailableNextDay;

  public StudyQueue(int lessonsAvailable, int reviewsAvailable, long nextReviewDate, 
                          int reviewsAvailableNextHour, int reviewsAvailableNextDay) {
    this.lessonsAvailable = lessonsAvailable;
    this.reviewsAvailable = reviewsAvailable;
    this.nextReviewDate = nextReviewDate;
    this.reviewsAvailableNextHour = reviewsAvailableNextHour;
    this.reviewsAvailableNextDay = reviewsAvailableNextDay;
  }

  /**
   * @return the number of lessons available
   */
  public int getLessonsAvailable() {
    return lessonsAvailable;
  }

  /**
   * @return the number of lessons available
   */
  public int getReviewsAvailable() {
    return reviewsAvailable;
  }

  /**
   * @return the timestamp of the next review date
   */
  public long getNextReviewDate() {
    return nextReviewDate;
  }

  /**
   * @return the number of reviews available within the next hour
   */
  public int getReviewsAvailableNextHour() {
    return reviewsAvailableNextHour;
  }

  /**
   * @return the number of reviews available within the next day
   */
  public int getReviewsAvailableNextDay() {
    return reviewsAvailableNextDay;
  }
}