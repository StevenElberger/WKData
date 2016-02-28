package com.steve.wkdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A custom deserializer for the CriticalItemsList class.
 * @author Steve
 */
public class CriticalItemsListDeserializer extends JsonDeserializer<CriticalItemsList> {

  @Override
  public CriticalItemsList deserialize(JsonParser jp, DeserializationContext ctxt) 
                                      throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    node = node.get("requested_information");
    /*
     * API specifics:
     * - can have multiple meanings and kun'yomi (separated by ", ")
     * - kun'yomi can be "None"
     * - nanori can be null
     * - "." indicates the end point of the kanji's reading
     * - sometimes there's also ".*" to indicate the rest of the kanji's reading
     * - percentage can be null
     */
    ArrayList<Item> itemsReturned = new ArrayList<>(node.size());
    for (int i = 0; i < node.size(); i++) {
      JsonNode nextItem = node.get(i);
      String type = nextItem.get("type").asText();
      String character = nextItem.get("character").asText();
      String meaning = nextItem.get("meaning").asText();
      String[] meanings = meaning.split(", ");
      int level = Integer.parseInt(nextItem.get("level").asText());
      Integer percentage = null;
      if (nextItem.get("percentage") != null) {
        percentage = Integer.parseInt(nextItem.get("percentage").asText());
      }
      if (type.equals("vocabulary")) {
        String kana = nextItem.get("kana").asText();
        itemsReturned.add(new CriticalItemsList.CriticalVocabulary(type, character, kana, 
                        meanings, level, percentage));
      } else if (type.equals("radical")) {
        String image = nextItem.get("image").asText();
        itemsReturned.add(new CriticalItemsList.CriticalRadical(type, character, meanings, 
                            image, level, percentage));
      } else if (type.equals("kanji")) {
        String onyomi = nextItem.get("onyomi").asText();
        String kun = nextItem.get("kunyomi").asText();
        String[] kunyomi = kun.split(", ");
        String nanori = nextItem.get("nanori").asText();
        if (nanori.equals("null")) {
          nanori = null;
        }
        String importantReading = nextItem.get("important_reading").asText();
        itemsReturned.add(new CriticalItemsList.CriticalKanji(type, character, meanings, onyomi, 
                kunyomi, nanori, importantReading, level, percentage));
      }
    }
    long lastRefreshed = System.currentTimeMillis();
    return new CriticalItemsList(itemsReturned, lastRefreshed);
  }
}