// 07 typo: primitave Assignments: TJ Ch 8 ex 1, 4, 5
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Random;

public class Hello {
	public static int[] randomArray(int size) {
		Random random = new Random();
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(100);
		}
		return a;
	}
	
	// #1.1
	public static double[] powArray(double[] a, int x) {
		double[] result = new double[a.length];
		
		for(int i=0; i<a.length; i++) {
			result[i] = Math.pow(a[i], x);
		}
		
		return result;
	}
	
	// #1.2
	public static int[] histogram(int[] a) {
		int[] histo = new int[100];
		
		// use element value as counter index
		for (int num : a) {
			histo[num]++;
		}
		
		return histo;
	}
	
	// generalized to specified number of counters
	public static int[] histogram(int[] a, int numCounters) {
		int[] histo = new int[numCounters];
		
		// use element value as counter index
		for (int num : a) {
			histo[num]++;
		}
		
		return histo;
	}
	
	// #4 - array must have >= 1 element
	public static int indexOfMax(int[] a) {
		int maxIndex = 0;
		int max = a[0];  // takes care of first element
		
		for (int i=1; i<a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	// #5
	// helper function: given boolean array a and current index i, find the index of the next prime
	// Does this by searching for next "true" flag
	public static int findNextPrimeIndex(boolean[] a, int i) {
		for (i++; i<a.length; i++) {  // search after current index
			if (a[i]) {  // looking for true
				return i;
			}
		}
		return i; // No more found
	}
	
	// implementing the Sieve of Eratosthenes
	public static boolean[] sieve(int n) {
		boolean[] result = new boolean[n];  // Java initializes to false
		// set everything to true, then use sieve and turn composite #s to false
		for (int i=2; i<n; i++) {  // 0-1 not prime, so left alone
			result[i] = true;
		}
		
		for (int i=2; i < n; i = findNextPrimeIndex(result, i)) {
			for (int j=i*2; j<n; j += i) {  // the sieve - the first in each series is a prime
				result[j] = false;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		//#5
		int size = 100;  // or however many numbers to check for prime
		boolean[] sieved = sieve(size);
		
		for (int i=0; i < size; i++) {  
			System.out.printf("%d: ", i);
			System.out.print( sieved[i] + "   ");	
		}
		
		
/*		// #4
		int[] randArray = randomArray(8);
		System.out.println( Arrays.toString(randArray) + ", " + indexOfMax(randArray) );
		
		// #1.2
		int[] randArray = randomArray(6);
		int[] histoArray = histogram(randArray, 100);
		System.out.println( Arrays.toString(randArray) );
		System.out.println( Arrays.toString(histoArray) );
		
		// #1.1
		double[] testArray = {0,1,2,3.5,1.1};
		System.out.println( Arrays.toString( powArray(testArray, 3) ) );
*/	}

}