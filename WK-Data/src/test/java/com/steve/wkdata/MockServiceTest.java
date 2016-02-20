package com.steve.wkdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.io.IOException;

public class MockServiceTest {

  @Test
  public void getUserInformation_serializes() throws JsonParseException, JsonMappingException, 
                                                                                      IOException {
    // SET UP
    ObjectMapper mapper = new ObjectMapper();
    WaniKaniUser wkr = mapper.readValue(MockService.getUserInformation(), 
                                                        WaniKaniUser.class);

    // ACT
    UserInformation userInformation = wkr.getUserInformation();

    // ASSERT
    assertNotNull(userInformation);
    assertEquals(userInformation.getUsername(), "BSheep");
  }

  @Test
  public void getStudyInfo_serializes() throws JsonParseException, JsonMappingException, 
                                                                                      IOException {
    // SET UP
    ObjectMapper mapper = new ObjectMapper();
    WaniKaniUser wkr = mapper.readValue(MockService.getStudyQueue(), WaniKaniUser.class);

    // ACT
    StudyQueue studyQueue = wkr.getStudyQueue();

    // ASSERT
    assertNotNull(studyQueue);
    assertEquals(studyQueue.getReviewsAvailable(), 136);
  }

  @Test
  public void getLevelProgression_serializes() throws JsonParseException, JsonMappingException,
                                                                                      IOException {
    // SET UP
    ObjectMapper mapper = new ObjectMapper();
    WaniKaniUser wkr = mapper.readValue(MockService.getLevelProgression(), WaniKaniUser.class);

    // ACT
    LevelProgression levelProgression = wkr.getLevelProgression();

    // ASSERT
    assertNotNull(levelProgression);
    assertEquals(levelProgression.getKanjiProgress(), 6);
  }

  @Test
  public void getSRSDistribution_serializes() throws JsonParseException, JsonMappingException,
                                                                                      IOException {
    //SET UP
    ObjectMapper mapper = new ObjectMapper();
    WaniKaniUser wkr = mapper.readValue(MockService.getSRSDistribution(), WaniKaniUser.class);

    // ACT
    SRSDistribution srsDistribution = wkr.getSRSDistribution();

    // ASSERT
    assertNotNull(srsDistribution);
    assertNotNull(srsDistribution.getApprentice());
    assertEquals(srsDistribution.getApprentice().getRadicals(), 1);
    assertEquals(srsDistribution.getApprentice().getKanji(), 38);
    assertEquals(srsDistribution.getApprentice().getVocabulary(), 117);
    assertEquals(srsDistribution.getApprentice().getTotal(), 156);
  }
}