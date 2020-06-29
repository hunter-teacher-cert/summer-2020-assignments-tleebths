import java.util.*;

public class Factorial {

	/* 
	 * Returns: long
	 * Given int n, calculates n! using recursion
	 */
	public static long factorial(int n) {
		if (n <= 0) {
			return 1;
		}
		
		return n * factorial(n-1);  // n! = n * (n-1)!
	}

    public static void main(String[] args) {
    	int n = Integer.parseInt( args[0] );  // arg from command-line
    	
    	System.out.print("Factorial of " + n + " = ");
    	System.out.println(factorial(n));
    	
    }
}
