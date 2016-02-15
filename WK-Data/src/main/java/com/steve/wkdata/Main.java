package com.steve.wkdata;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
  private static final String KEY = "1c57a9204555418f1ae60fd8f25ff2ed";

  /**
   * Attempts to get data from WaniKani.
   * @param args command line args
   */
  public static void main(String[] args) {
    OkHttpClient client = new OkHttpClient();
    Request request;
    Response response;
    try {
      HttpUrl url = new HttpUrl.Builder()
              .scheme("https")
              .host("www.wanikani.com")
              .addPathSegment("api")
              .addPathSegment("user")
              .addPathSegment(KEY)
              .build();
      request = new Request.Builder()
          .url(url)
          .build();
      response = client.newCall(request).execute();
      ObjectMapper mapper = new ObjectMapper();
      WaniKaniResponse waniKaniResponse = mapper.readValue(response.body().string(), WaniKaniResponse.class);
      System.out.println(waniKaniResponse.getUserInformation().getUsername());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}