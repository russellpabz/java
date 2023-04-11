import java.util.Random;
import java.util.Scanner;

public class LabExer5A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(50) + 1;
        int numberOfGuesses = 0;
        
        while (true) {
            System.out.print("Guess the number (between 1 and 50): ");
            try {
                int guess = scanner.nextInt();
                numberOfGuesses++;
                
                if (guess < 1 || guess > 50) {
                    throw new Exception("Out of range.");
                }
                
                if (guess == numberToGuess) {
                    System.out.println("Congratulations, you guessed the number in " + numberOfGuesses + " guesses!");
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low. Guess again.");
                } else {
                    System.out.println("Too high. Guess again.");
                }
            } catch (Exception e) {
                scanner.nextLine(); // consume remaining input
                System.out.println("Invalid input. " + e.getMessage() + " Guess again.");
            }
        }
        
        scanner.close();
    }
}