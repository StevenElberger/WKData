package com.steve.wkdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * A custom deserializer for the UserInformation class.
 * @author Steve
 */
public class UserInformationDeserializer extends JsonDeserializer<UserInformation> {

  @Override
  public UserInformation deserialize(JsonParser jp, DeserializationContext ctxt) 
                                      throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    node = node.get("user_information");
    String username = node.get("username").asText();
    String gravatar = node.get("gravatar").asText();
    int level = Integer.parseInt(node.get("level").asText());
    String title = node.get("title").asText();
    String about = node.get("about").asText();
    String website = node.get("website").asText();
    String twitter = node.get("twitter").asText();
    int topicsCount = Integer.parseInt(node.get("topics_count").asText());
    int postsCount = Integer.parseInt(node.get("posts_count").asText());
    long creationDate = Long.parseLong(node.get("creation_date").asText()) * 1000;
    String vacationString = node.get("vacation_date").asText();
    Long vacationDate;
    if (vacationString.equals("null")) {
      vacationDate = null;
    } else {
      vacationDate = Long.parseLong(node.get("vacation_date").asText()) * 1000;
    }
    long lastRefreshed = System.currentTimeMillis();
    return new UserInformation(username, gravatar, level, title, 
                                about, website, twitter, topicsCount, 
                                postsCount, creationDate, vacationDate, lastRefreshed);
  }
}