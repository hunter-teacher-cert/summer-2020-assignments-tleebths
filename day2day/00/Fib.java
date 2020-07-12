import java.util.*;

// Implements a tail recusive version of calculating fibonacci seq.
public class Fib {

	/*
	 * Returns an int, fib(a)
	 * Parameter contains 3 elements [a, f0, f1], such that:
	 * f0 and f1 start as seeds, the first two numbers of the series.
	 * They're the accumulators representing fib(n-1) and fib(n-2).
	 * a is initially the a-th fib # we want. It will be decremented
	 * at each turn. Initially, f(0) = f0, f(1)=f1.
	 */
	public static int fib(int[] data) {
		System.out.print("Entering fib, data=" + Arrays.toString(data));
		int a = data[0];
		System.out.print(" a=" + a);

		if (a < 2) {
			return data[a+1];
		} else {
			// modifies input array to avoid making new one
			data[0]--;
			System.out.print(" f0=" + data[1]);
			System.out.print(" f1=" + data[2]);

			int temp = data[1] + data[2];  // calculate next in sequence
			data[1] = data[2];  // updates, keeping only last 2 #s
			data[2] = temp;     // in the sequence

			System.out.println("exiting " + data[0]);
			return fib(data);
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
		int[] data = new int[]{n, f0, f1};

    	System.out.printf("\nfib(%d) = %d", n, fib(data));

	}
}
