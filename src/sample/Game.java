package sample;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by brisson22 on 2016-07-10.
 */
public class Game {

    private int numberOfGuesses;
    private boolean endGame;
    private String userName;
    private String jarItem;
    private int maxItems;
    private int totalItems;
    private int highScore = 0;
    private int guess;
    private boolean correct;
    private String scoreName;

    public String guessString;

    public Game() {

//        Scanner in = new Scanner(System.in);
//        System.out.printf("Please enter user name (\"Admin\" to customize game): %n");
//        userName = in.nextLine();
//        user();
        fill();
    }

    public void user() {
        if (userName.equalsIgnoreCase("Admin") || userName.equalsIgnoreCase("administrator")) {
            fill();
        } else {
            System.out.printf("Good luck, %s%n", userName);
            jarItem ="taco";
            maxItems = 500;
            grammar();
            play();
        }
    }

    public void fill() {
        System.out.print("Enter the object name that will be filling the jar: ");
        Scanner in = new Scanner(System.in);
        jarItem = in.nextLine();
        grammar();
        System.out.printf("Please enter the maximum amount of %s: ", jarItem.toUpperCase());
        maxItems = Integer.parseInt(in.nextLine());
//        System.out.printf("The jar will be filled randomly between 1 and %d, %s", maxItems, jarItem.toUpperCase());
        randomNumber();
        play();
    }

    public void grammar() {
        if (jarItem.toLowerCase().endsWith("y")) {
            //Not going to worry about words like mouse/mice
            // or singular words that end with s, etc.
            if(jarItem.toLowerCase().endsWith("ay")|| jarItem.endsWith("ey") ||
                    jarItem.endsWith("iy") || jarItem.endsWith("oy") || jarItem.endsWith("uy")) {
                jarItem += "s";
            } else {

                StringBuilder builder = new StringBuilder(jarItem);
                builder.deleteCharAt(jarItem.length() - 1);
                jarItem = builder.toString() + "ies";
            }

        }
            if (jarItem.toLowerCase().endsWith("s")) {
            } else {
            jarItem += "s";
        }
    }

    public String pluralGuess(String string, Integer integer) {
        if (integer > 1) {
            string += "es";
        } else {
            return guessString = string;
        }
        return guessString = string;
    }

    public void title() {
        char[] caps = scoreName.toCharArray();
        caps[0] = Character.toUpperCase(caps[0]);
        scoreName = new String(caps);
    }

    public void randomNumber() {

        Random random = new Random();
        totalItems = random.nextInt(maxItems)+1;
    }

    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            numberOfGuesses = 0;
            System.out.printf("The jar is filled with %s%n%n", jarItem.toUpperCase());
            System.out.printf("The range is between 1 and %d%n", maxItems);
            Scanner in = new Scanner(System.in);
            do {
                correct = false;
                System.out.printf("Guess how many %s are in the jar: %n", jarItem);
                guess = in.nextInt();
                if (guess > maxItems) {
                    System.out.printf("Oops...the maximum amount of %s that could be in the jar is %d%n", jarItem, maxItems);
                    System.out.printf("Try a guess that doesn't exceed %d%n", maxItems);
                    guess = in.nextInt();
                }
                numberOfGuesses++;
                if (guess > totalItems) {
                    System.out.printf("Sorry, %d is too high!%n", guess);
                }
                if (guess < totalItems) {
                    System.out.printf("Unfortunately %d is too low!%n", guess);
                }
                if (guess == totalItems) {
                    System.out.printf("Congrats!!! %d was the exact number%n", guess);
                    pluralGuess("guess", numberOfGuesses);
                    System.out.printf("It took you %d %s%n", numberOfGuesses, guessString);
                    if (numberOfGuesses == highScore) {
                        System.out.printf("You tied the high score but %s did it first%n", scoreName);
                    } else
                    if (highScore == 0 || highScore > numberOfGuesses) {
                        highScore = numberOfGuesses;
                        System.out.printf("You have the new high score!...%n");
                        System.out.printf("Enter your name to be immortalized (until someone else defeats you!)%n");
                        Scanner n = new Scanner(System.in);
                        scoreName = n.nextLine();
                        title();
                        System.out.printf("I doubt anyone will beat %s's score%n", scoreName);
                    }
                    else {
                        System.out.printf("Good game, but %s has the high score of %d%n%n", scoreName, highScore);
                    }

                    correct = true;
                    System.out.printf("Would you like to play again?%n (\"yes\" or \"no\")%n");
                    Scanner ta = new Scanner(System.in);
                    String tryAgain = ta.nextLine();
                    if (tryAgain.equalsIgnoreCase("yes") || tryAgain.equalsIgnoreCase("y")) {
                        randomNumber();

//                        play();
                    } else {
                        gameOver = true;
//                        System.exit(0);
//                        highScore = 0;
                        fill();
                    }
                }
            } while (!correct);
        }
    }
}
