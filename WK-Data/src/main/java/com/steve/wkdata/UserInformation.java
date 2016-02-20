package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A representation of WK's user_information object.
 * 
 * @author Steve
 */
@JsonDeserialize(using = UserInformationDeserializer.class)
public class UserInformation {

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
   */
  @JsonProperty("vacation_date")
  private Long vacationDate;

  public UserInformation(String username, String gravatar, int level,
                          String title, String about, String website,
                          String twitter, int topicsCount, int postsCount,
                          long creationDate, Long vacationDate) {
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
  }
  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @return the gravatar ID
   */
  public String getGravatar() {
    return gravatar;
  }

  /**
   * @return the user's level
   */
  public int getLevel() {
    return level;
  }

  /**
   * @return the title of the user's section
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return the about string
   */
  public String getAbout() {
    return about;
  }

  /**
   * @return the website URL
   */
  public String getWebsite() {
    return website;
  }

  /**
   * @return the twitter username
   */
  public String getTwitter() {
    return twitter;
  }

  /**
   * @return the number of forum topics created
   */
  public int getTopicsCount() {
    return topicsCount;
  }

  /**
   * @return the number of forum posts created
   */
  public int getPostsCount() {
    return postsCount;
  }

  /**
   * @return the account creation date (unix timestamp)
   */
  public long getCreationDate() {
    return creationDate;
  }

  /**
   * @return the vacation start date (Unix timestamp)
   */
  public Long getVacationDate() {
    return vacationDate;
  }
}