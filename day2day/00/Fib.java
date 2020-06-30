import java.util.*;

public class Fib {

	/* 
	 * Returns: long
	 * Given long n, calculates fibonacci(n) using recursion
	 * Definitions: fib(0) = 0, fib(1) = 1
	 */
	public static int[] fibonacci(int[] sequence, int i) {
		if (i == 0) {
			sequence[0] = 0;
		} else if (i == 1) {
			sequence = fibonacci(sequence, i-1);
			sequence[1] = 1;
		} else {
			sequence = fibonacci(sequence, i-1);
			sequence[i] = sequence[i-1] + sequence[i-2];
		}
		
		return sequence;

	}
	
	public static int[] fib(int n) {
		// create the array to track each fib
		// To find fib(1), we need fib(0) and fib(1)
		int[] sequence = new int[n+1];
		
		//process the rest of the fibs from fib(n-1)
		sequence = fibonacci(sequence, n);
		return sequence[n];
		
	}
	
    public static void main(String[] args) {
    	int n = Integer.parseInt( args[0] );  // arg from command-line
		
    	System.out.print("fib(" + n + ") = ");
    	System.out.println(fib(n));

	}
}
