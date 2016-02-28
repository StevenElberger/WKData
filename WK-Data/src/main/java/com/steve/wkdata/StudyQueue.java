package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A representation of a study queue object.
 * @author Steve
 */
@JsonDeserialize(using = StudyQueueDeserializer.class)
public class StudyQueue implements Expirable {
  /**
   * The expiration time limit for this object. Set to 1 hour.
   */
  private static final long EXPIRATION_TIME = 60 * 60 * 1000;
  /**
   * The timestamp of the last time this object was refreshed with new data.
   */
  private long lastRefreshed = 0;
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
   * May be {@code null}.
   */
  @JsonProperty("next_review_date")
  private Long nextReviewDate;
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

  /**
   * Constructor.
   * @param lessonsAvailable the num of lessons available
   * @param reviewsAvailable the num of reviews available
   * @param nextReviewDate the next review date
   * @param reviewsAvailableNextHour the num of reviews available in the next hour
   * @param reviewsAvailableNextDay the num of reviews available in the next day
   * @param lastRefreshed the time this object was constructed (expiration purposes)
   */
  public StudyQueue(int lessonsAvailable, int reviewsAvailable, 
                    long nextReviewDate, int reviewsAvailableNextHour, 
                    int reviewsAvailableNextDay, long lastRefreshed) {
    this.lessonsAvailable = lessonsAvailable;
    this.reviewsAvailable = reviewsAvailable;
    this.nextReviewDate = nextReviewDate;
    this.reviewsAvailableNextHour = reviewsAvailableNextHour;
    this.reviewsAvailableNextDay = reviewsAvailableNextDay;
    this.lastRefreshed = lastRefreshed;
  }

  /**
   * Checks if the data has expired.
   * @return true if expired, false otherwise
   */
  @Override
  public boolean isExpired() {
    return System.currentTimeMillis() - EXPIRATION_TIME >= lastRefreshed;
  }

  public long getLastRefreshed() {
    return lastRefreshed;
  }

  public int getLessonsAvailable() {
    return lessonsAvailable;
  }

  public int getReviewsAvailable() {
    return reviewsAvailable;
  }

  public Long getNextReviewDate() {
    return nextReviewDate;
  }

  public int getReviewsAvailableNextHour() {
    return reviewsAvailableNextHour;
  }

  public int getReviewsAvailableNextDay() {
    return reviewsAvailableNextDay;
  }
}