import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 * Solves TJ Ch 6 Ex 2, 3, 8
 * by TL
 */
public class Methods {
	// #2
	public static boolean isDivisible(int n, int m) {
		return n%m == 0;
	}
	
	// #3
	public static boolean isTriangle(int a, int b, int c) {
		if (a + b <= c) {
			return false;
		} else if (a + c <= b) {
			return false;
		} else if (b + c <= a) {
			return false;
		} else {
			return true;
		}
	}
	
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
		// invalid arguments
		System.err.println("arguments to ack should not be negative");
		return -99999; // doesn't matter since args invalid
	}
	
	public static void main(String[] args) {
		int m, n;  // for Ackermann function
		Scanner in = new Scanner(System.in);
		
		// #8
		System.out.println("Calculating the Ackermann function...");
		System.out.print("m = ");
		m = in.nextInt();
		in.nextLine();

		System.out.print("n = ");
		n = in.nextInt();
		in.nextLine();

		System.out.print("A(" + m + "," + n + ") = " + ack(m,n));

		// #2
		System.out.println("5 divisible by 2? " + isDivisible(5,2));
		System.out.println("22 divisible by 11? " + isDivisible(22,11));
		
		// #3
		System.out.println("3, 4, 5? " + isTriangle(3,4,5)); // should be true
		System.out.println("3, 4, 7? " + isTriangle(3,4,7)); // should be false
		System.out.println("3, 10, 5? " + isTriangle(3,10,5)); // should be false
		System.out.println("17, 4, 13? " + isTriangle(17,4,13)); // should be false
		System.out.println("3, 10, 8? " + isTriangle(3,10,8)); // should be true
		System.out.println("17, 4, 20? " + isTriangle(3,4,5)); // should be true
	
	}
}