package CODSOFT;

import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 5;
        boolean won = false;

        Scanner input = new Scanner(System.in);

        while (attempts < maxAttempts && !won) {
            System.out.print("Guess a number between 1 and 100: ...");
            int guess = input.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                won = true;
                System.out.println("Congratulations! You won in " + attempts + " attempts.");
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!won) {
            System.out.println("Sorry, you didn't guess the number.... It was " + numberToGuess + ".");
        }

        System.out.println("Do you want to play again? (y/n)");
        String response = input.next();

        if (response.equalsIgnoreCase("y")) {
            main(args); // Restart the game
        }
    }
}


