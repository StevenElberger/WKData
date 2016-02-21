package com.steve.wkdata;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Application entry point. Simply takes an API key
 * and prompts the user to select data to retrieve and display.
 * @author Steve
 */
public class Main {
  private static WaniKaniUser user;

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
    System.out.println("1) Print user information");
    System.out.println("2) Print study queue");
    System.out.println("3) Print level progression");
    System.out.println("4) Print SRS distribution");
    System.out.println("5) Quit\n");
  }

  /**
   * Reads input from the user and executes the selection.
   */
  public static void mainLoop() {
    int userInput = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter an API key: ");
    user = new WaniKaniUser(scanner.nextLine());
    while (userInput != 5) {
      printMenu();
      System.out.println("Please enter a selection: ");
      userInput = Integer.parseInt(scanner.nextLine());
      processAction(userInput);
    }
    scanner.close();
  }

  /**
   * Processes the user's response and acts accordingly.
   * @param userInput the input from the user
   */
  public static void processAction(int userInput) {
    switch (userInput) {
    case 1:
      printUserInformation();
      break;
    case 2:
      printStudyQueue();
      break;
    case 3:
      printLevelProgression();
      break;
    case 4:
      printSRSDistribution();
    default:
      break;
    }
  }

  /**
   * Prints the user's user information.
   */
  public static void printUserInformation() {
    long refreshTime = user.getCallTimestamps()[0];
    UserInformation userInfo;
    try {
      userInfo = user.getUserInformation();
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
    } catch (IOException e) {
      System.out.println("Error getting user information");
    }
  }

  /**
   * Prints the user's study queue.
   */
  public static void printStudyQueue() {
    long refreshTime = user.getCallTimestamps()[1];
    StudyQueue studyQueue;
    try {
        studyQueue = user.getStudyQueue();
      System.out.println("Displaying level progression:");
      System.out.println("Last refreshed: " + new Date(refreshTime));
      System.out.println("Lessons available: " + studyQueue.getLessonsAvailable());
      System.out.println("Reviews available: " + studyQueue.getReviewsAvailable());
      System.out.println("Next review date: " + new Date(studyQueue.getNextReviewDate()));
      System.out.println("Reviews available next hour: " + studyQueue.getReviewsAvailableNextHour());
      System.out.println("Reviews available next day: " + studyQueue.getReviewsAvailableNextDay());
    } catch (IOException e) {
      System.out.println("Error getting study queue");
    }
  }

  /**
   * Prints the user's level progression.
   */
  public static void printLevelProgression() {
    long refreshTime = user.getCallTimestamps()[2];
    LevelProgression levelProgression;
    try {
      levelProgression = user.getLevelProgression();
      System.out.println("Displaying level progression:");
      System.out.println("Last refreshed: " + new Date(refreshTime));
      System.out.println("Radicals progress: " + levelProgression.getRadicalsProgress());
      System.out.println("Radicals total: " + levelProgression.getRadicalsTotal());
      System.out.println("Kanji progress: " + levelProgression.getKanjiProgress());
      System.out.println("Kanji total: " + levelProgression.getKanjiTotal());
    } catch (IOException e) {
      System.out.println("Error getting level progression");
    }
  }

  /**
   * Prints the user's SRS distribution.
   */
  public static void printSRSDistribution() {
    long refreshTime = user.getCallTimestamps()[3];
    SRSDistribution srsDistribution;
    try {
      srsDistribution = user.getSRSDistribution();
      System.out.println("Displaying level progression:");
      System.out.println("Last refreshed: " + new Date(refreshTime));
      System.out.println("Apprentice---");
      System.out.println("Radicals: " + srsDistribution.getApprentice().getRadicals());
      System.out.println("Kanji: " + srsDistribution.getApprentice().getKanji());
      System.out.println("Vocabulary: " + srsDistribution.getApprentice().getVocabulary());
      System.out.println("Total: " + srsDistribution.getApprentice().getTotal());
      System.out.println("Guru---");
      System.out.println("Radicals: " + srsDistribution.getGuru().getRadicals());
      System.out.println("Kanji: " + srsDistribution.getGuru().getKanji());
      System.out.println("Vocabulary: " + srsDistribution.getGuru().getVocabulary());
      System.out.println("Total: " + srsDistribution.getGuru().getTotal());
      System.out.println("Master---");
      System.out.println("Radicals: " + srsDistribution.getMaster().getRadicals());
      System.out.println("Kanji: " + srsDistribution.getMaster().getKanji());
      System.out.println("Vocabulary: " + srsDistribution.getMaster().getVocabulary());
      System.out.println("Total: " + srsDistribution.getMaster().getTotal());
      System.out.println("Enlighten---");
      System.out.println("Radicals: " + srsDistribution.getEnlighten().getRadicals());
      System.out.println("Kanji: " + srsDistribution.getEnlighten().getKanji());
      System.out.println("Vocabulary: " + srsDistribution.getEnlighten().getVocabulary());
      System.out.println("Total: " + srsDistribution.getEnlighten().getTotal());
      System.out.println("Burned---");
      System.out.println("Radicals: " + srsDistribution.getBurned().getRadicals());
      System.out.println("Kanji: " + srsDistribution.getBurned().getKanji());
      System.out.println("Vocabulary: " + srsDistribution.getBurned().getVocabulary());
      System.out.println("Total: " + srsDistribution.getBurned().getTotal());
    } catch (IOException e) {
      System.out.println("Error getting level progression");
    }
  }
}