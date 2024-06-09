import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;

        while (playAgain) {
            int start = 1;
            int end = 100;
            int numberToGuess = random.nextInt(end - start + 1) + start;
            int attempts = 0;
            boolean correctGuess = false;
            int maxAttempts = 10;  // Limit the number of attempts

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I have generated a random number between " + start + " and " + end + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    correctGuess = true;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
            }

            totalRounds++;
            totalAttempts += attempts;

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! You played " + totalRounds + " rounds with an average of " + (totalAttempts / (double) totalRounds) + " attempts per round.");
        scanner.close();
    }
}
