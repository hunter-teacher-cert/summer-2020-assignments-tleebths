import java.io.*;
import java.util.*;

public class Gridz2 {
	public static void main(String[] args) {
		
		// int[row][column]
		int[][] arr = new int[10][5];
		
		printArray2D(arr);
	}

	public static void printArray2D(int[][] ia) {
		for(int r=0; r < ia.length; r++) {
			printArray(ia[r]);  // prints row r
		}  // end row
	}
	
	public static void printArray(int[] ia) {
		
		for (int c=0; c < ia.length; c++) {
			System.out.printf("%02d ", ia[c]);
		}  // end for i
			
		System.out.println();
	}  // end printArray

}  // end class