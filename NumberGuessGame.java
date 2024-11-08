import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    private static final int MAX_ATTEMPTS = 5;
    private static final int SCORE_MULTIPLIER = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Enhanced Number Guessing Game!");

        while (playAgain) {
            roundsPlayed++;
            int score = playRound(scanner);
            totalScore += score;

            System.out.println("Your score for this round: " + score);
            System.out.println("Total score after " + roundsPlayed + " round(s): " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You played " + roundsPlayed + " round(s) with a total score of " + totalScore + ".");
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int score = MAX_ATTEMPTS * SCORE_MULTIPLIER;

        System.out.println("\nI've picked a number between 1 and 100. Try to guess it in " + MAX_ATTEMPTS + " attempts!");

        while (attempts < MAX_ATTEMPTS) {
            int userGuess = getUserGuess(scanner, attempts);
            attempts++;

            if (userGuess == numberToGuess) {
                System.out.println("Correct! You've guessed the number in " + attempts + " attempt(s).");
                score -= (attempts - 1) * SCORE_MULTIPLIER;  // Deduct score for extra attempts
                return score;
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Too low!");
            }

            System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - attempts));
        }

        System.out.println("Sorry, you've used all attempts! The correct number was: " + numberToGuess);
        return 0;  // Zero score if the player didn't guess correctly
    }

    private static int getUserGuess(Scanner scanner, int attempts) {
        while (true) {
            System.out.print("Attempt " + (attempts + 1) + " - Enter your guess: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();  // Clear invalid input
            }
        }
    }
}
