import java.util.*;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Number Game ! You have only 6 Attempt to Guess Number");

        // Generating a random number using the random function.
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int guessingChances = 0;
        System.out.print("Enter the Number for Guessing the Random Number: ");
        int userInput = sc.nextInt();

        while (userInput >= 0 && userInput < 100) {

            if (guessingChances > 6) {

                System.out.println("You have used all your chances to guess the Random Number");
                System.out.println("The Random Number was: " + randomNumber);
                System.out.println("You have used " + guessingChances + " chances to guess the Random Number");
                break;
            }
            if (userInput <= 0) {
                System.out.println("Please Enter a Number Greater than or equal to 0");
                System.out.print("Enter the Number: ");
                userInput = sc.nextInt();
            } else if (userInput >= 100) {
                System.out.println("Please Enter a Number Lower than 100");
                System.out.print("Enter the Number: ");
                userInput = sc.nextInt();
            } else if (userInput > randomNumber) {
                System.out.println("Your Number is Higher than the Random Number");
                System.out.print("Enter the Number: ");
                userInput = sc.nextInt();
            } else if (userInput < randomNumber) {
                System.out.println("Your Number is Lower than the Random Number");
                System.out.print("Enter the Number: ");
                userInput = sc.nextInt();
            } else{
                System.out.println("Congratulations! You Guessed the Random Number: " + randomNumber);
                System.out.println("The Random Number was: " + randomNumber);
                System.out.println("You have used " + guessingChances + " chances to guess the Random Number");
                break;
            }
            guessingChances++;
        }
        // Close the Scanner object
        sc.close();
    }
}