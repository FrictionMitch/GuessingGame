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
    private int highScore;

    public Game() {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter user name : ");
        userName = in.nextLine();
        user();
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
        System.out.printf("The jar will be filled randomly between 1 and %d, %s", maxItems, jarItem.toUpperCase());
        randomNumber();
    }

    public void grammar() {
        if (jarItem.toLowerCase().endsWith("y")) {
            //Not going to worry about words like mouse/mice
            // or singular words that end with s, etc.

            StringBuilder builder = new StringBuilder(jarItem);
            builder.deleteCharAt(jarItem.length()-1);
            jarItem = builder.toString() + "ies";

        }
            if (jarItem.toLowerCase().endsWith("s")) {
            } else {
            jarItem += "s";
        }
    }

    public void randomNumber() {

        Random random = new Random();
        totalItems = random.nextInt(maxItems + 1);
    }

    public void play() {
        System.out.printf("The jar is filled with %s%n%n", jarItem.toUpperCase());
        System.out.printf("The range is between 1 and %d", maxItems);
    }
}
