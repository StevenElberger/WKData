package com.steve.wkdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.steve.wkdata.SRSDistribution.SRSItem;

import java.io.IOException;

/**
 * A custom deserializer for the SRSDistribution class.
 * @author Steve
 */
public class SRSDistributionDeserializer extends JsonDeserializer<SRSDistribution> {

  @Override
  public SRSDistribution deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    node = node.get("requested_information");
    String[] nodes = {"apprentice", "guru", "master", "enlighten", "burned"};
    SRSDistribution srsDistribution = new SRSDistribution();
    SRSItem[] items = new SRSItem[5];
    for (int i = 0; i < nodes.length; i++) {
      JsonNode dataNode = node.get(nodes[i]);
      int radicals = Integer.parseInt(dataNode.get("radicals").asText());
      int kanji = Integer.parseInt(dataNode.get("kanji").asText());
      int vocabulary = Integer.parseInt(dataNode.get("vocabulary").asText());
      int total = Integer.parseInt(dataNode.get("total").asText());
      items[i] = srsDistribution.new SRSItem(radicals, kanji, vocabulary, total);
    }
    srsDistribution.setApprentice(items[0]);
    srsDistribution.setGuru(items[1]);
    srsDistribution.setMaster(items[2]);
    srsDistribution.setEnlighten(items[3]);
    srsDistribution.setBurned(items[4]);
    return srsDistribution;
  }
}