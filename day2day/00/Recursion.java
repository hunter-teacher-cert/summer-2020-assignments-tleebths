import java.io.*;
import java.util.*;

public class Recursion {

	public static void main(String[] args) {
    	int m = Integer.parseInt( args[0] );  // arg from command-line
		int n;  // there may not be a second argument
		
		System.out.println("Math genie here!");
    	System.out.println(m + "! = " + fact(m));  // uses first argument
		System.out.println("fib(" + m + ") = " + fib(m));
		
		if (args.length > 1) {
			n = Integer.parseInt( args[1] );
			System.out.println("A(" + m + "," + n + ") = " + ack(m,n));
		}

		System.out.println("Sum of the array is " + recursiveSum(args));
	}

	/**
	 * Returns the sum of an array
	 * @param sa an array of String's that are actually int's
	 * @return the sum of those numbers
	 */
	public static int recursiveSum(String[] sa) {
		// Base case: empty array
		if (sa.length == 0) {
			return 0;
		}
		
    	int m = Integer.parseInt( sa[0] );  // first arg
		// copyOfRange copies from index 1 up to but not incl. index sa.length
		return m + recursiveSum(Arrays.copyOfRange(sa, 1, sa.length));
	}

	/* m and n should not be negative
	A(m, n) = 	
				  n+1	if  m = 0
			A(m−1, 1)	if  m > 0  and  n = 0
	A(m−1, A(m, n−1))	if  m > 0  and  n > 0
	table of values to check ans: https://helloacm.com/ackermann-function/
	*/
	public static int ack(int m, int n) {
		if (m == 0)
			return n+1;
		if (m > 0) {
			if (n == 0) {
				return ack(m-1, 1);
			} else if (n > 0) {
				return ack(m-1, ack(m, n-1));
			}
		}
		
		// shouldn't get to this point, invalid arguments
		return -99999;
	}

	// 4: Similarities: each level is defined by a simplification to a lower level (argument closer to base case)
	//    Differences: fib becomes exponentially more complicated (or more?)

	/* 
	 * Returns: int
	 * Given int n, calculates fibonacci(n) using recursion
	 * Definitions: fib(0) = 0, fib(1) = 1
	 */
	public static int fib(int n) {
		if (n < 1) {
			return 0;
		} else if (n < 2) {
			return 1;
		}
		
		return fib(n-1) + fib(n-2);
	}
	
	/* 
	 * Returns: long
	 * Given int n, calculates n! using recursion
	 */
	public static long fact(int n) {
		if (n <= 0) {
			return 1;
		}
		
		return n * fact(n-1);  // n! = n * (n-1)!
	}
}