// TJ Ch 7 Ex 3, 4, 5
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;

public class Loops {
	// #3: iterative, only works for non-negative exponents
	public static double power(double x, int n) {
		int result = 1;  // to store answer. also x^0 = 1
		
		int i = 0;
		while (i<n) {
			result *= x;
			i++;
		}
		
		return result;
	}
	
	// #4: iterative
	public static long fact(int n) {
		int result = 1;
		
		for(int i=n; i>0; i--) {
			result *= i;
		}
		
		return result;
	}
	
	// #5 v1 - n should be non-negative
/*	public static double myexp(int x, int n) {
		if (n == 0)
			return 1.0;
		else
//			System.out.print("power = " + power(x,n) + " factorial = " + fact(n));
//			System.out.println(" myexp(x,n) = " + myexp(x, n-1));
			return myexp(x, n-1) + power(x,n) / fact(n);
	}
*/	
	// #5 v2 - n should be non-negative
	public static double myexp(int x, int n) {
		double result = 1.0, nthTerm = 1.0;
		
		// nth term is (n-1)th term * x / n
		for(int i=1; i<=n; i++) {
			nthTerm *= 1.0 * x/i;  //avoid int division
//			System.out.printf("x = %d  n = %d  nthTerm = %f", x, n, nthTerm);
			result += nthTerm;
//			System.out.println(" result = " + result);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// #5
		System.out.print("Estimate e^");
		int x = in.nextInt();
		System.out.print("for how many terms? ");
		int n = in.nextInt();
		
		System.out.printf("e^%d ~= %f", x, myexp(x,n));
		System.out.println();
		
		
/*		// #4
		System.out.print("factorial for? ");
		int n = in.nextInt();
		
		System.out.printf("factorial(%d) = %d", n, fact(n));
		System.out.println();
		
		// #3
		double base;
		int exp;
		
		System.out.print("base = ");
		base = in.nextDouble();
		System.out.print("exponent = ");
		exp = in.nextInt();
		
		System.out.printf("%.2f ^ %d = %.2f", base, exp, power(base, exp));
		System.out.println();
*/	}
}