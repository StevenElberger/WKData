package com.steve.wkdata;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

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

  public static void processAction(int userInput) {
    try {
      switch (userInput) {
      case 1:
        user.getUserInformation();
        break;
      case 2:
        user.getLevelProgression();
        break;
      case 3:
        user.getSRSDistribution();
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
}