import java.io.*;
import java.util.*;

public class GridImage {

	public static void main(String[] args) {

		int rows = 10;  // initialize 20x20 array
		int cols = 10;
		int[][] grid = new int[rows][cols];

//		rowPop(grid, 1, 255);
//		colPop(grid, 5, 2);
//		invert(grid);
		diagonal(grid, 8, 3, 0, 111);
		diagonal(grid, 0, 5, 3, 222);

		print2d(grid);
		System.out.println();

	}

	/*
		0: up + left
		1: up + right
		2: down + left
		3: down + right
	 */

	 // Recursive solution
 	public static void diagonal(int[][] d2, int r, int c, int direction, int value) {
 		if (r >= d2.length || c >= d2[0].length || r < 0 || c < 0)
 			return;  // base cases: arrayIndexOutOfBounds

 		d2[r][c] = value;  // recursive case: flip the element, go to next "coordinate"

 		direction < 2 ? r-- : r++ ; // up or down

 		direction % 2 == 0 ? c-- : c++ ; // left or right

 		diagonal(d2, r, c, direction, value);
	}  //end diagonal

	 // iterative solution
/*	 public static void diagonal(int[][] d2, int r, int c, int direction, int value) {
		while (r < d2.length && c < d2[0].length && r >= 0 && c >= 0) {
			d2[r][c] = value;  // recursive case: flip the element, go to next "coordinate"

			if (direction == 0) {
				r = r - 1;
				c = c - 1;
			} else if (direction == 1) {
				r = r - 1;
				c = c + 1;
			} else if (direction == 2) {
				r = r + 1;
				c = c - 1;
			} else {
				r = r + 1;
				c = c + 1;
			}

		} // end while

	}
*/
	public static void print2d(int[][] d2) {

		for (int r=0; r < d2.length; r++) {
			for (int c=0; c < d2[r].length; c++) {

				System.out.printf("%03d ", d2[r][c]);
			}//end c for

			System.out.println();
		}//end r for
	}//end print2d

	public static void colPop(int[][] d2, int c, int value) {
		for (int i=0; i < d2.length; i++) {
			d2[i][c] = value;
		}
	}//end colPop

	// Populates row r in d2 with value
	public static void rowPop(int[][] d2, int r, int value) {
		for (int i=0; i < d2[r].length; i++) {
			d2[r][i] = value;
		}

	}//end rowPop

	public static void invert(int[][] d2) {
		for (int r=0; r < d2.length; r++) {
			for (int c=0; c < d2.length; c++) {
				if (d2[r][c] != 0)
					d2[r][c] = 0;
				else
					d2[r][c] = 255;
			}  // end c
		}  // end r

	}//end invert


}	// end class
