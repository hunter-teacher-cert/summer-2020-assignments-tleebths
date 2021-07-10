import java.util.*;

public class Classwork200629v2 {

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

	/* #8: m and n should not be negative
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

	public static void factorial(String arg) {
    	int n = Integer.parseInt( arg );  // arg from command-line
    	System.out.print(n + "! = ");
    	System.out.println(fact(n));
	}

	public static void fibonacci(String arg) {
    	long n = Long.parseLong( arg );  // arg from command-line
	
		System.out.print("fib(" + n + ") = ");
		System.out.println(fib(n));
	}

	public static void ackermann(String[] mn) {
		int m, n;  // for Ackermann function

    	m = Integer.parseInt( mn[0] );
    	n = Integer.parseInt( mn[1] );
		
		System.out.println("A(" + m + "," + n + ") = " + ack(m,n));
	}

    public static void main(String[] args) {
		
		if ( args[0].equals("fact") ) {
			factorial(args[1]);
		} else if ( args[0].equals("fib") ) {
			fibonacci(args[1]);
		} else if ( args[0].equals("ack") ) {
			ackermann(new String[]{args[1], args[2]});
		}
    	
	}
	
}
