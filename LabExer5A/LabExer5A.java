/**
* Author. Russell C. Pabon.
* Laboratory exercise: Guessing game!
* Activity: 05 Hands-on Activity 1 - ARG
*/

import java.util.Random;
import java.util.Scanner;
import java.text.MessageFormat;

public class LabExer5A {

    private static String author = "Russell C. Pabon BSIT-1B";

    private static String teacher = "Toto Escototo";

    private static String subject = "Computer Programming 2";

    private static byte numberOfGuesses = 0;

    private static byte minRandomNumber = 1;

    private static byte maxRandomNumber = 50;
    
    private static int randomNumber = 0;

    private static byte playAgain = 0; 

    private static void printWelcomMessage(){
        System.out.println("================================================================");
        System.out.println("= Guessing Game (with try and catch) Error Exception handling  =");
        System.out.println(String.format("= Created by  : %s                       =", author));
        System.out.println(String.format("= Teacher     : %s                                  =", teacher));
        System.out.println(String.format("= Subject     : %s                         =", subject));
        System.out.println("================================================================");
    }

    private static int generateRandomNumber(){
        return (int)(Math.random() * ((maxRandomNumber - minRandomNumber) + 1)) + minRandomNumber;
    }

    private static Boolean playAgain(){

        if(playAgain != 1) return false;

        //Reset variables
        playAgain = 0;
        numberOfGuesses = 0;
        randomNumber = generateRandomNumber();
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        printWelcomMessage();

        randomNumber = generateRandomNumber();
        
        while(true) {
           
            System.out.print(String.format("Guess the number from %d to %d: ", minRandomNumber, maxRandomNumber));

            //Use this for debuging
            //System.out.print(String.format("The answer is %d: ", randomNumber));

            try {

                numberOfGuesses++;

                if(scanner.hasNextByte()) {
                    int guess = scanner.nextByte();

                    if (guess < 1 || guess > maxRandomNumber) {
                        throw new Exception("Exception error: Out of range.");
                    }
                    
                    if (guess == randomNumber) {
                        System.out.println(String.format("You got it in %d attemp(s)!", numberOfGuesses));
                        System.out.println("Play Again? : Press 1");

                        playAgain = scanner.nextByte();

                        if(playAgain() == false){
                            break;
                        }

                    } else if (guess < randomNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                }
                else{
                    throw new Exception("Exception error: None numeric character.");
                }

            } catch (Exception e) {
                scanner.nextLine(); 
                System.out.println(String.format("%s", e.getMessage()));
            }
        }
        
        scanner.close();
    }
}