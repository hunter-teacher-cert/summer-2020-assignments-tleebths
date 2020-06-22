import java.util.Random;
import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class GuessStarter {

    public static void main(String[] args) {
		// initialize
		Scanner in = new Scanner(System.in);
		int guess;  // user input
        Random random = new Random();
		int number;  // computer-generated secret
		
        // pick a random number
        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.println("(including both). Can you guess what it is?");
        number = random.nextInt(100) + 1;
		
		// prompt user
		System.out.print("Type a number: ");
		guess = in.nextInt();
		in.nextLine();  // clears buffer after input
		
		// reporting
		System.out.println("Your guess is: " + guess);
		System.out.println("The number I was thinking of is: " + number);
		System.out.println("You were off by: " + Math.abs(number-guess));
    }
}