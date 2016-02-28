package com.steve.wkdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

public class MockServiceTest {

  @Test
  public void getUserInformation_serializes() throws JsonParseException, JsonMappingException, 
                                                                                      IOException {
    // SET UP
    ObjectMapper mapper = new ObjectMapper();
    WaniKaniUser wkr = mapper.readValue(MockService.getUserInformation(), 
                                                        WaniKaniUser.class);

    // ACT
    Optional<UserInformation> userInformation = wkr.getUserInformation();

    // ASSERT
    assertTrue(userInformation.isPresent());
    assertEquals(userInformation.get().getUsername(), "BSheep");
  }

  @Test
  public void getStudyInfo_serializes() throws JsonParseException, JsonMappingException, 
                                                                                      IOException {
    // SET UP
    ObjectMapper mapper = new ObjectMapper();
    WaniKaniUser wkr = mapper.readValue(MockService.getStudyQueue(), WaniKaniUser.class);

    // ACT
    Optional<StudyQueue> studyQueue = wkr.getStudyQueue();

    // ASSERT
    assertTrue(studyQueue.isPresent());
    assertEquals(studyQueue.get().getReviewsAvailable(), 136);
  }

  @Test
  public void getLevelProgression_serializes() throws JsonParseException, JsonMappingException,
                                                                                      IOException {
    // SET UP
    ObjectMapper mapper = new ObjectMapper();
    WaniKaniUser wkr = mapper.readValue(MockService.getLevelProgression(), WaniKaniUser.class);

    // ACT
    Optional<LevelProgression> levelProgression = wkr.getLevelProgression();

    // ASSERT
    assertTrue(levelProgression.isPresent());
    assertEquals(levelProgression.get().getKanjiProgress(), 6);
  }

  @Test
  public void getSrsDistribution_serializes() throws JsonParseException, JsonMappingException,
                                                                                      IOException {
    //SET UP
    ObjectMapper mapper = new ObjectMapper();
    WaniKaniUser wkr = mapper.readValue(MockService.getSrsDistribution(), WaniKaniUser.class);

    // ACT
    Optional<SrsDistribution> srsDistribution = wkr.getSrsDistribution();

    // ASSERT
    assertTrue(srsDistribution.isPresent());
    assertNotNull(srsDistribution.get().getApprentice());
    assertEquals(srsDistribution.get().getApprentice().getRadicals(), 1);
    assertEquals(srsDistribution.get().getApprentice().getKanji(), 38);
    assertEquals(srsDistribution.get().getApprentice().getVocabulary(), 117);
    assertEquals(srsDistribution.get().getApprentice().getTotal(), 156);
  }
}