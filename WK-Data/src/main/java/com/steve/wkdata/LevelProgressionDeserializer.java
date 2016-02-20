package com.steve.wkdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * A custom deserializer for the LevelProgression class.
 * @author Steve
 */
public class LevelProgressionDeserializer extends JsonDeserializer<LevelProgression> {

  @Override
  public LevelProgression deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    node = node.get("requested_information");
    int radicalsProgress = Integer.parseInt(node.get("radicals_progress").asText());
    int radicalsTotal = Integer.parseInt(node.get("radicals_total").asText());
    int kanjiProgress = Integer.parseInt(node.get("kanji_progress").asText());
    int kanjiTotal = Integer.parseInt(node.get("kanji_total").asText());
    return new LevelProgression(radicalsProgress, radicalsTotal, kanjiProgress, kanjiTotal);
  }
}