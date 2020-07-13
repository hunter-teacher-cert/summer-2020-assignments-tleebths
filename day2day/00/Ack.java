import java.io.*;
import java.util.*;

public class Ack {

	public static void main(String[] args) {
    	int m = Integer.parseInt( args[0] );
		int n = Integer.parseInt( args[1] );
		// Using object matrix so null means not calculated yet
		// ackermann is not a primitive recursive function
		Integer[][] results = new Integer[200][200];

		System.out.println("A(" + m + "," + n + ") = " + ack(m, n, results));
	}

	/* m and n should not be negative
	A(m, n) =
				  n+1	if  m = 0
			A(m−1, 1)	if  m > 0  and  n = 0
	A(m−1, A(m, n−1))	if  m > 0  and  n > 0
	table of values to check ans: https://helloacm.com/ackermann-function/
	*/
	public static int ack(int m, int n, Integer[][] results) {
		//System.out.printf("m=%d, n=%d\n", m, n);
		// return answer if already calculated
		if (results[m][n] != null)
			return results[m][n];

		if (m == 0) {
			results[m][n] = n+1;
			return n+1;
		}
		if (m > 0) {
			int x;

			if (n == 0) {
				if (results[m][n] != null)
					x = results[m][n];
				else {
					x = ack(m-1, 1, results);
					results[m][n] = x;
				}

				return x;
			} else if (n > 0) {
				if (results[m][n] != null)
					x = results[m][n];
				else {
					x = ack(m-1, ack(m, n-1, results), results);
				}

				return x;
			}
		}

		// shouldn't get to this point, invalid arguments
		return Integer.MIN_VALUE;
	}

}  // end class
