package com.steve.wkdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A representation of WK's user_information object.
 * 
 * @author Steve
 */
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
  private int creationDate;
  /**
   * The time from which the user has been on vacation status.
   */
  @JsonProperty("vacation_date")
  private int vacationDate;

  /**
   * Gets the user's username.
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Gets the gravatar ID.
   * @return the gravatar ID
   */
  public String getGravatar() {
    return gravatar;
  }

  /**
   * Gets the user's level.
   * @return the user's level
   */
  public int getLevel() {
    return level;
  }

  /**
   * Gets the title of the user's section.
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the user's about string.
   * @return the about string
   */
  public String getAbout() {
    return about;
  }

  /**
   * Gets the user's website URL.
   * @return the website URL
   */
  public String getWebsite() {
    return website;
  }

  /**
   * Gets the user's Twitter username.
   * @return the twitter username
   */
  public String getTwitter() {
    return twitter;
  }

  /**
   * Gets the number of forum topics created.
   * @return the number of forum topics created
   */
  public int getTopicsCount() {
    return topicsCount;
  }

  /**
   * Gets the number of forum posts created.
   * @return the number of forum posts created
   */
  public int getPostsCount() {
    return postsCount;
  }

  /**
   * Gets the Unix timestamp of the account creation date.
   * @return the account creation date (unix timestamp)
   */
  public int getCreationDate() {
    return creationDate;
  }

  /**
   * Gets the Unix timestamp of the time the user set their status to vacation.
   * @return the vacation start date (Unix timestamp)
   */
  public int getVacationDate() {
    return vacationDate;
  }
}