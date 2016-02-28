package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A representation of WK's user_information object.
 * 
 * @author Steve
 */
@JsonDeserialize(using = UserInformationDeserializer.class)
public class UserInformation implements Expirable {
  /**
   * The expiration time limit for this object. Set to 1 hour.
   */
  private static final long EXPIRATION_TIME = 60 * 60 * 1000;
  /**
   * The timestamp of the last time this object was refreshed with new data.
   */
  private long lastRefreshed = 0;
  /**
   * The username.
   */
  @JsonProperty("username")
  private String username;
  /**
   * The gravatar ID.
   */
  @JsonProperty("gravatar")
  private String gravatar;
  /**
   * The user's level.
   */
  @JsonProperty("level")
  private int level;
  /**
   * The title of the user's section.
   */
  @JsonProperty("title")
  private String title;
  /**
   * The user's "About" string.
   */
  @JsonProperty("about")
  private String about;
  /**
   * The user's website URL.
   */
  @JsonProperty("website")
  private String website;
  /**
   * The user's twitter username.
   */
  @JsonProperty("twitter")
  private String twitter;
  /**
   * The number of topics created on the forums by the user.
   */
  @JsonProperty("topics_count")
  private int topicsCount;
  /**
   * The number of posts created on the forums by the user.
   */
  @JsonProperty("posts_count")
  private int postsCount;
  /**
   * The user's account creation date.
   */
  @JsonProperty("creation_date")
  private long creationDate;
  /**
   * The time from which the user has been on vacation status.
   * May be {@code null}.
   */
  @JsonProperty("vacation_date")
  private Long vacationDate;

  /**
   * Constructor.
   * @param username the user's username
   * @param gravatar the user's gravatar md5
   * @param level the user's level
   * @param title the user's title
   * @param about the user's about me string
   * @param website the user's website
   * @param twitter the user's twitter username
   * @param topicsCount the num of topics created
   * @param postsCount the num of posts created
   * @param creationDate the account creation date
   * @param vacationDate the time account was put on vacation, if applicable
   * @param lastRefreshed the time this object was constructed (expiration purposes)
   */
  public UserInformation(String username, String gravatar, int level,
                          String title, String about, String website,
                          String twitter, int topicsCount, int postsCount,
                          long creationDate, Long vacationDate, long lastRefreshed) {
    this.username = username;
    this.gravatar = gravatar;
    this.level = level;
    this.title = title;
    this.about = about;
    this.website = website;
    this.twitter = twitter;
    this.topicsCount = topicsCount;
    this.postsCount = postsCount;
    this.creationDate = creationDate;
    this.vacationDate = vacationDate;
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

  public String getUsername() {
    return username;
  }

  public String getGravatar() {
    return gravatar;
  }

  public int getLevel() {
    return level;
  }

  public String getTitle() {
    return title;
  }

  public String getAbout() {
    return about;
  }

  public String getWebsite() {
    return website;
  }

  public String getTwitter() {
    return twitter;
  }

  public int getTopicsCount() {
    return topicsCount;
  }

  public int getPostsCount() {
    return postsCount;
  }

  public long getCreationDate() {
    return creationDate;
  }

  public Long getVacationDate() {
    return vacationDate;
  }
}