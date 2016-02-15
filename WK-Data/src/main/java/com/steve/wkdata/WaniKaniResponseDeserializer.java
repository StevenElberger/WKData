package com.steve.wkdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * A custom deserializer for the WaniKaniResponse class.
 * Necessary for determining what the requested information is, if any.
 * @author Steve
 */
public class WaniKaniResponseDeserializer extends JsonDeserializer<WaniKaniResponse> {

  @Override
  public WaniKaniResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    WaniKaniResponse response;
    ObjectMapper mapper = new ObjectMapper();

    // write the node's value as a string for serializing
    String userInfoJSON = mapper.writeValueAsString(node.get("user_information"));
    UserInformation userInformation = mapper.readValue(userInfoJSON, UserInformation.class);

    // determine what type of info was requested, if any
    node = node.get("requested_information");
    if (node.has("lessons_available")) {
      String studyQueueJSON = mapper.writeValueAsString(node);
      StudyQueue studyQueue = mapper.readValue(studyQueueJSON, StudyQueue.class);
      response = new WaniKaniResponse(userInformation, studyQueue);  
    } else if (node.has("radicals_progress")) {
      String levelProgressionJSON = mapper.writeValueAsString(node);
      LevelProgression levelProgression = mapper.readValue(levelProgressionJSON, LevelProgression.class);
      response = new WaniKaniResponse(userInformation, levelProgression);
    } else {
      response = new WaniKaniResponse(userInformation);
    }

    return response;
  }
}