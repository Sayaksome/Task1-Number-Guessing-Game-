import java.util.Random;
import java.util.Scanner;

class RandomNumberGenerator {
    public int generate(int upperBound, int lowerBound) {
        Random random = new Random();
        return random.nextInt((upperBound - lowerBound) + 1) + lowerBound;
    }
}

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomNumberGenerator rng = new RandomNumberGenerator();
        int totalGuesses = 0;
        int totalWins = 0;

        while (true) {
            System.out.print("Please enter the upper bound: ");
            int upperBound = scanner.nextInt();
            System.out.print("Please enter the lower bound: ");
            int lowerBound = scanner.nextInt();

            // Validate bounds
            if (lowerBound >= upperBound) {
                System.out.println("The lower bound must be less than the upper bound. Try again.");
                continue;
            }

            int targetNumber = rng.generate(upperBound, lowerBound);
            int guessCount = 0;

            while (true) {
                System.out.printf("Make a guess between %d and %d:\n", lowerBound, upperBound);
                int userGuess = scanner.nextInt();
                guessCount++;

                if (userGuess > targetNumber) {
                    System.out.println("Too high.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Congratulations! You've guessed it!");
                    totalWins++;
                    break;
                }
            }
            totalGuesses += guessCount;
            System.out.println("Total guesses for this round: " + guessCount);
            System.out.println("Total wins so far: " + totalWins);

            double winRate = (double) totalWins / totalGuesses * 100;
            System.out.printf("Your current win rate is %.2f%%\n", winRate);

            System.out.print("Would you like to play again (yes/no)? ");
            String playAgainResponse = scanner.next();
            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
