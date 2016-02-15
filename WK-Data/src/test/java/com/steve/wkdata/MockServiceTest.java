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
    WaniKaniResponse wkr = mapper.readValue(MockService.getUserInformation(), 
                                                        WaniKaniResponse.class);

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
    WaniKaniResponse wkr = mapper.readValue(MockService.getStudyQueue(), WaniKaniResponse.class);

    // ACT
    StudyQueue studyQueue = wkr.getStudyQueue();

    // ASSERT
    assertNotNull(studyQueue);
    assertEquals(studyQueue.getReviewsAvailable(), 136);
  }
}