package com.steve.wkdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
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
    System.out.println("5) Print recent unlocks list");
    System.out.println("6) Print critical items list");
    System.out.println("7) Quit\n");
  }

  /**
   * Reads input from the user and executes the selection.
   */
  public static void mainLoop() {
    int userInput = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter an API key: ");
    user = new WaniKaniUser(scanner.nextLine());
    while (userInput != 7) {
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
        printSrsDistribution();
        break;
      case 5:
        printRecentUnlocksList();
        break;
      case 6:
        printCriticalItemsList();
        break;
      default:
        break;
    }
  }

  /**
   * Prints the user's user information.
   */
  public static void printUserInformation() {
    Optional<UserInformation> userInfoResponse = user.getUserInformation();
    if (userInfoResponse.isPresent()) {
      UserInformation userInfo = userInfoResponse.get();
      System.out.println("Displaying user information:");
      System.out.println("Last refreshed: " + new Date(userInfo.getLastRefreshed()));
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
    }
  }

  /**
   * Prints the user's study queue.
   */
  public static void printStudyQueue() {
    Optional<StudyQueue> studyQueueResponse = user.getStudyQueue();
    if (studyQueueResponse.isPresent()) {
      StudyQueue studyQueue = studyQueueResponse.get();
      System.out.println("Displaying study queue:");
      System.out.println("Last refreshed: " + new Date(studyQueue.getLastRefreshed()));
      System.out.println("Lessons available: " + studyQueue.getLessonsAvailable());
      System.out.println("Reviews available: " + studyQueue.getReviewsAvailable());
      if (studyQueue.getNextReviewDate() == null) {
        System.out.println("Next review date: null");
      } else {
        System.out.println("Next review date: " + new Date(studyQueue.getNextReviewDate()));
      }
      System.out.println("Reviews available next hr: " + studyQueue.getReviewsAvailableNextHour());
      System.out.println("Reviews available next day: " + studyQueue.getReviewsAvailableNextDay());
    }
  }

  /**
   * Prints the user's level progression.
   */
  public static void printLevelProgression() {
    Optional<LevelProgression> levelProgressionResponse = user.getLevelProgression();
    if (levelProgressionResponse.isPresent()) {
      LevelProgression levelProgression = levelProgressionResponse.get();
      System.out.println("Displaying level progression:");
      System.out.println("Last refreshed: " + new Date(levelProgression.getLastRefreshed()));
      System.out.println("Radicals progress: " + levelProgression.getRadicalsProgress());
      System.out.println("Radicals total: " + levelProgression.getRadicalsTotal());
      System.out.println("Kanji progress: " + levelProgression.getKanjiProgress());
      System.out.println("Kanji total: " + levelProgression.getKanjiTotal());
    }
  }

  /**
   * Prints the user's SRS distribution.
   */
  public static void printSrsDistribution() {
    Optional<SrsDistribution> srsDistributionResponse = user.getSrsDistribution();
    if (srsDistributionResponse.isPresent()) {
      SrsDistribution srsDistribution = srsDistributionResponse.get();
      System.out.println("Displaying srs distribution:");
      System.out.println("Last refreshed: " + new Date(srsDistribution.getLastRefreshed()));
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
    }
  }

  /**
   * Prints the user's recent unlocks list.
   */
  public static void printRecentUnlocksList() {
    Optional<RecentUnlocksList> recentUnlocksListResponse = user.getRecentUnlocksList();
    if (recentUnlocksListResponse.isPresent()) {
      ItemsList recentUnlocksList = recentUnlocksListResponse.get();
      System.out.println("Display recent unlocks list:");
      System.out.println("Last refreshed: " + new Date(recentUnlocksList.getLastRefreshed()));
      ArrayList<Item> itemList = recentUnlocksList.getList();
      for (int i = 0; i < itemList.size(); i++) {
        String type = itemList.get(i).getType();
        System.out.println("Type: " + type);
        System.out.println("Character: " + itemList.get(i).getCharacter());
        String[] meanings = itemList.get(i).getMeaning();
        for (int j = 0; j < meanings.length; j++) {
          System.out.println("Meaning[" + j + "]: " + meanings[j]);
        }
        System.out.println("Level: " + itemList.get(i).getLevel());
        if (type.equals("vocabulary")) {
          RecentUnlocksList.RecentUnlockVocabulary item = 
                  (RecentUnlocksList.RecentUnlockVocabulary) itemList.get(i);
          System.out.println("Unlocked date: " + new Date(item.getUnlockDate()));
          System.out.println("Kana: " + item.getKana());
        } else if (type.equals("Radical")) {
          RecentUnlocksList.RecentUnlockRadical item = 
                  (RecentUnlocksList.RecentUnlockRadical) itemList.get(i);
          System.out.println("Unlocked date: " + new Date(item.getUnlockDate()));
          if (item.getImage() != null) {
            System.out.println("Image: " + item.getImage());
          }
        } else if (type.equals("Kanji")) {
          RecentUnlocksList.RecentUnlockKanji item = 
                  (RecentUnlocksList.RecentUnlockKanji) itemList.get(i);
          System.out.println("Unlocked date: " + new Date(item.getUnlockDate()));
          System.out.println("On'yomi: " + item.getOnyomi());
          if (item.getKunyomi() != null) {
            System.out.println("Kun'yomi: " + item.getKunyomi());
          }
          System.out.println("Nanori: " + item.getNanori());
          System.out.println("Important reading: " + item.getImportantReading());
        }
      }
    }
  }

  /**
   * Prints the user's critical items list.
   */
  public static void printCriticalItemsList() {
    Optional<CriticalItemsList> criticalItemsListResponse = user.getCriticalItemsList();
    if (criticalItemsListResponse.isPresent()) {
        CriticalItemsList criticalItemsList = criticalItemsListResponse.get();
      System.out.println("Display recent unlocks list:");
      System.out.println("Last refreshed: " + new Date(criticalItemsList.getLastRefreshed()));
      ArrayList<Item> itemList = criticalItemsList.getList();
      for (int i = 0; i < itemList.size(); i++) {
        String type = itemList.get(i).getType();
        System.out.println("Type: " + type);
        System.out.println("Character: " + itemList.get(i).getCharacter());
        String[] meanings = itemList.get(i).getMeaning();
        for (int j = 0; j < meanings.length; j++) {
          System.out.println("Meaning[" + j + "]: " + meanings[j]);
        }
        System.out.println("Level: " + itemList.get(i).getLevel());
        if (type.equals("vocabulary")) {
          CriticalItemsList.CriticalVocabulary item = 
                  (CriticalItemsList.CriticalVocabulary) itemList.get(i);
          System.out.println("Percentage: " + item.getPercentage());
          System.out.println("Kana: " + item.getKana());
        } else if (type.equals("Radical")) {
          CriticalItemsList.CriticalRadical item = 
                  (CriticalItemsList.CriticalRadical) itemList.get(i);
          System.out.println("Percentage: " + item.getPercentage());
          if (item.getImage() != null) {
            System.out.println("Image: " + item.getImage());
          }
        } else if (type.equals("Kanji")) {
          CriticalItemsList.CriticalKanji item = 
                  (CriticalItemsList.CriticalKanji) itemList.get(i);
          System.out.println("Percentage: " + item.getPercentage());
          System.out.println("On'yomi: " + item.getOnyomi());
          if (item.getKunyomi() != null) {
            System.out.println("Kun'yomi: " + item.getKunyomi());
          }
          System.out.println("Nanori: " + item.getNanori());
          System.out.println("Important reading: " + item.getImportantReading());
        }
      }
    }
  }
}