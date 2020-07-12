import java.util.*;

public class FibTail {

	/*
	 * Returns an int, fib(a)
	 * Parameter contains 3 elements [a, f0, f1], such that:
	 * f0 and f1 start as seeds, the first two numbers of the series.
	 * They're the accumulators representing fib(n-1) and fib(n-2).
	 * a is initially the a-th fib # we want. It will be decremented
	 * at each turn. Initially, f(0) = f0, f(1)=f1.
	 */
	public static int fib(int[] data) {
		if (a < 2) {
			return data[a];
		} else {
			data[0]--;
			temp = data[1] + data[2];  // calculate next in sequence
			data[1] = data[2];  // updates, keeping only last 2 #s
			data[2] = temp;     // in the sequence
			return go(data);
		}

	}  // end go()

    public static void main(String[] args) {
    	int f0 = Integer.parseInt( args[0] );  // arg from command-line

    	System.out.print("fib(" + n + ") = ");
    	System.out.println(fib(n));

	}
}
