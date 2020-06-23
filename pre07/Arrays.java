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
	public static boolean[] sieve(int[] a) {
		
	}
	
	public static void main(String[] args) {
		//#5
		int[] randArray = randomArray(10);
		System.out.println( Arrays.toString(randArray) );
		System.out.println( Arrays.toString(sieve(randArray)) );	
		
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