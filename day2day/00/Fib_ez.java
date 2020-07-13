import java.util.*;

// Implements a tail recusive version of calculating fibonacci seq.
public class Fib {

	/*
	 * Returns an int, fib(a)
	 * Parameters: a, f0, f1, such that:
	 * f0 and f1 start as seeds, the first two numbers of the series.
	 * They're the accumulators representing fib(n-1) and fib(n-2).
	 * a is initially the a-th fib # we want. It will be decremented
	 * at each turn. Initially, f(0) = f0, f(1)=f1.
	 */
	public static int fib(int n, int f0, int f1) {
		if (n < 2) {
			return f0;
		} else {
			n--;

			int next = f0 + f1;  // calculate next in sequence
			f0 = f1;  // updates, keeping only last 2 #s
			f1 = next;     // in the sequence

			return fib(n, f0, f1);
		}

	}  // end go()

	/* Uses arguments from command line, [n, f0, f1], such that:
	 * We'll calculate the n-th fibonacci number
	 * using f0 and f1 as the initial sequence
	*/
    public static void main(String[] args) {
    	int n = Integer.parseInt( args[0] );
		int f0 = Integer.parseInt( args[1] );
		int f1 = Integer.parseInt( args[2] );

    	System.out.printf("\nfib(%d) = %d", n, fib(n, f0, f1));

	}
}
