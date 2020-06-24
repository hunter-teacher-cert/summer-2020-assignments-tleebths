import java.io.*;
import java.util.*;
import java.util.Random;

public class Hello {
	/*
	 * Returns a random # b/t 1 & n, incl.
	 */
	public static int roll(int n) {
		Random random = new Random();

		return random.nextInt(n) + 1;
	}
	
	/*
	 * Expects the # of dice, and max value for those dice
	 * Returns: result of rolling those dice
	 */
	public static int shoot(int numDice, int maxValue) {
		if (numDice == 0) {
			return 0;
		} else {
			return shoot(numDice - 1, maxValue) + roll(maxValue);
		}
	}
	
	/*
	 * Returns: Whether the shooter of the round wins or loses
	 */
	public static boolean round() {
		// initialize
		int NUM_DICE = 2, MAX_VALUE = 6;
		
		int rolled = shoot(NUM_DICE, MAX_VALUE);
		System.out.print("New Round: rolling " + rolled + " ");
		
		if (rolled == 2 || rolled == 3 || rolled == 12) {  // Craps, loses
			return false;
		} else if (rolled == 7 || rolled == 11) {  // Natural, wins
			return true;
		}
		
		int point = rolled;
		System.out.print("Point=" + point + ". Rolling: ");
		
		while (true) {
			rolled = shoot(NUM_DICE, MAX_VALUE);
			System.out.print(rolled + " ");
			
			if (rolled == point) {
				return true;
			} else if (rolled == 7) {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		// initialize
		int numRounds = Integer.parseInt(args[0]);
		
		// 
		for (int i=0; i<numRounds; i++) {
			if (round()) {	// true means win
				System.out.println("WINS!");
			} else {
				System.out.println("LOSES!");
			}
		}
	}
}