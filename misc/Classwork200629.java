import java.util.*;

public class Classwork200629 {

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

	/* 
	 * Returns: long
	 * Given long n, calculates fibonacci(n) using recursion
	 * Definitions: fib(0) = 0, fib(1) = 1
	 */
	public static long fib(long n) {
		if (n < 1) {
			return 0;
		} else if (n < 2) {
			return 1;
		}
		
		return fib(n-1) + fib(n-2);
	}
	
	// 4: Similarities: each level is defined by a simplification to a lower level (argument closer to base case)
	//    Differences: fib becomes exponentially more complicated (or more?)

    public static void main(String[] args) {
    	long n = Long.parseLong( args[0] );  // arg from command-line
		
    	System.out.print("fib(" + n + ") = ");
    	System.out.println(fib(n));

/*    	int n = Integer.parseInt( args[0] );  // arg from command-line
    	System.out.print(n + "! = ");
    	System.out.println(factorial(n));
    	
 */ }
}
