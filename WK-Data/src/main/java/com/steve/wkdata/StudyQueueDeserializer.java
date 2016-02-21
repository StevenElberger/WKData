package com.steve.wkdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * A custom deserializer for the StudyQueue class.
 * @author Steve
 */
public class StudyQueueDeserializer extends JsonDeserializer<StudyQueue> {

  @Override
  public StudyQueue deserialize(JsonParser jp, DeserializationContext ctxt) 
                                  throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    node = node.get("requested_information");
    int lessonsAvailable = Integer.parseInt(node.get("lessons_available").asText());
    int reviewsAvailable = Integer.parseInt(node.get("reviews_available").asText());
    String nextReviewDateString = node.get("next_review_date").asText();
    Long nextReviewDate;
    if (nextReviewDateString.equals("null")) {
      nextReviewDate = null;
    } else {
      nextReviewDate = Long.parseLong(node.get("next_review_date").asText()) * 1000;
    }
    int reviewsAvailableNextHour = 
            Integer.parseInt(node.get("reviews_available_next_hour").asText());
    int reviewsAvailableNextDay = Integer.parseInt(node.get("reviews_available_next_day").asText());
    long lastRefreshed = System.currentTimeMillis();
    return new StudyQueue(lessonsAvailable, reviewsAvailable, nextReviewDate, 
                            reviewsAvailableNextHour, reviewsAvailableNextDay, lastRefreshed);
  }
}