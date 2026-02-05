
/**
 * Write a description of class Numbergues here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; 
        int guess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");

        while (guess != secretNumber) {
            System.out.print("\nEnter your guess: ");
            guess = input.nextInt();
            attempts++;

            if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } 
            else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } 
            else {
                System.out.println("Congratulations!");
                System.out.println("You guessed it in " + attempts + " attempts!");

                if (attempts <= 5) {
                    System.out.println("Rating: Excellent! You're a mind reader!");
                } else if (attempts <= 10) {
                    System.out.println("Rating: Good job!");
                } else {
                    System.out.println("Rating: Keep practicing!");
                }
            }
        }

        input.close();
    }
}
