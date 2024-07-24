import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        while (playAgain) {
            System.out.print("Do you want to play with limits? (yes/no): ");
            String withLimitsResponse = scanner.next();
            boolean withLimits = withLimitsResponse.equalsIgnoreCase("yes");
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            int maxAttempts = withLimits ? 10 : Integer.MAX_VALUE;
            boolean hasGuessedCorrectly = false;
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            if (withLimits) {
                System.out.println("You have " + maxAttempts + " attempts to guess the number.");
            } else {
                System.out.println("You have unlimited attempts to guess the number.");
            }
            while (numberOfAttempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;
                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number correctly in " + numberOfAttempts + " attempts.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!hasGuessedCorrectly && withLimits) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was: " + numberToGuess);
            } else if (!hasGuessedCorrectly) {
                System.out.println("The number was: " + numberToGuess);
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}