package com.steve.wkdata;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
  private static final String KEY = "1c57a9204555418f1ae60fd8f25ff2ed";
  private static final long THIRTY_MINUTES = 30 * 60 * 1000;
  private static WaniKaniResponse user;

  /**
   * Attempts to get data from WaniKani.
   * @param args command line args
   */
  public static void main(String[] args) {
    mainLoop();
  }

  /**
   * Displays a simple menu with selections for the user.
   */
  public static void printMenu() {
    System.out.println("\nCurrent options are:");
    System.out.println("1) Get user information");
    System.out.println("2) Display level progression");
    System.out.println("3) Display SRS distribution");
    System.out.println("4) Print user information");
    System.out.println("5) Print level progression");
    System.out.println("6) Print SRS distribution");
    System.out.println("7) Quit\n");
  }

  /**
   * Reads input from the user and executes the selection.
   */
  public static void mainLoop() {
    int userInput = 0;
    Scanner scanner = new Scanner(System.in);
    while (userInput != 7) {
      printMenu();
      System.out.println("Please enter a selection: ");
      userInput = Integer.parseInt(scanner.nextLine());
      processAction(userInput);
    }
    scanner.close();
  }

  public static void processAction(int userInput) {
    OkHttpClient client = new OkHttpClient();
    Request request;
    Response response;
    HttpUrl url1 = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(KEY)
            .build();
    HttpUrl url2 = new HttpUrl.Builder()
            .scheme("https")
            .host("www.wanikani.com")
            .addPathSegment("api")
            .addPathSegment("user")
            .addPathSegment(KEY)
            .addPathSegment("study-queue")
            .build();
    try {
      switch (userInput) {
      case 1:
        if (user != null && checkIfDataExpired(0)) {
          request = new Request.Builder()
                  .url(url1)
                  .build();
          response = client.newCall(request).execute();
          if (response.isSuccessful()) {
            ObjectMapper mapper = new ObjectMapper();
            WaniKaniResponse wkr = mapper.readValue(response.body().string(), WaniKaniResponse.class);
            user.setUserInformation(wkr.getUserInformation());
            long[] newTimestamps = user.getCallTimestamps();
            newTimestamps[0] = System.currentTimeMillis();
            user.setCallTimestamps(newTimestamps);
          }
        } else if (user == null) {
          request = new Request.Builder()
                  .url(url1)
                  .build();
          response = client.newCall(request).execute();
          if (response.isSuccessful()) {
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(response.body().string(), WaniKaniResponse.class);
            long[] newTimestamps = user.getCallTimestamps();
            newTimestamps[0] = System.currentTimeMillis();
            user.setCallTimestamps(newTimestamps);
          }
        }
        break;
      case 2:
        if (user != null && checkIfDataExpired(1)) {
          request = new Request.Builder()
                  .url(url2)
                  .build();
          response = client.newCall(request).execute();
          if (response.isSuccessful()) {
            ObjectMapper mapper = new ObjectMapper();
            WaniKaniResponse wkr = mapper.readValue(response.body().string(), WaniKaniResponse.class);
            user.setStudyQueue(wkr.getStudyQueue());
            long[] newTimestamps = user.getCallTimestamps();
            newTimestamps[1] = System.currentTimeMillis();
            user.setCallTimestamps(newTimestamps);
          }
        }
        break;
      case 3:
        System.out.println("lol");
        break;
      case 4:
        if (user != null && user.getUserInformation() != null) {
          long refreshTime = user.getCallTimestamps()[0];
          UserInformation userInfo = user.getUserInformation();
          System.out.println("Displaying user information:");
          System.out.println("Last refreshed: " + new Date(refreshTime));
          System.out.println("Username: " + userInfo.getUsername());
          System.out.println("Gravatar: " + userInfo.getGravatar());
          System.out.println("Level: " + userInfo.getLevel());
          System.out.println("Title: " + userInfo.getTitle());
          if (userInfo.getAbout().equals("")) {
            System.out.println("About: \"\"");
          } else {
            System.out.println("About: " + userInfo.getAbout());
          }
          System.out.println("Website: " + userInfo.getWebsite());
          System.out.println("Twitter: " + userInfo.getTwitter());
          System.out.println("Number of Topics: " + userInfo.getTopicsCount());
          System.out.println("Number of posts: " + userInfo.getPostsCount());
          System.out.println("Creation date: " + new Date(userInfo.getCreationDate()));
          if (userInfo.getVacationDate() == null) {
            System.out.println("Vacation date: null");
          } else {
            System.out.println("Vacation date: " + new Date(userInfo.getVacationDate()));
          }
        } else {
          System.out.println("No user information to display");
        }
        break;
      case 5:
        System.out.println("lol");
        break;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean checkIfDataExpired(int index) {
    long timestamp = user.getCallTimestamps()[index];
    return System.currentTimeMillis() - THIRTY_MINUTES >= timestamp;
  }
}