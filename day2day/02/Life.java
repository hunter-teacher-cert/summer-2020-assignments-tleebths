import java.io.*;
import java.util.*;

/*
2D array

set up
change values in it

a way of applying the GOL rules
*/

class Life{

	/*
	create a new 2D array, fill it with ' '
	representing that the entire board is empty.
	*/
	public static char[][] createNewBoard(int rows, int cols){
		char[][] board = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				board[r][c] = ' ';
			}
		}
		return board;
	}

	// random board
	public static char[][] seed0() {
		int rows = 10, columns = 10;
		char[][] board = new char[rows][columns];

		for (int r=0; r<rows; r++) {
			for (int c=0; c<columns; c++) {
				board[r][c] = Math.random() < 0.5? 'X': ' ';
			}
		}  // end outer for

		return board;
	}  // end seed0();

	// simple infinite loop pattern 1, wiki page
	public static boolean[][] seed1() {
		boolean[][] board = new boolean[][] {
			{' ', ' ', ' ', ' ', ' '},
			{' ', ' ', 'X', ' ', ' '},
			{' ', ' ', 'X', ' ', ' '},
			{' ', ' ', 'X', ' ', ' '},
			{' ', ' ', ' ', ' ', ' '}
		};

		return board;
	}  // end seed1()

	// spaceship 1, wiki page
	public static boolean[][] seed2() {
		boolean[][] board = new boolean[][] {
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
		};

		return board;
	}  // end seed()


	public static void printBoard(char[][] board){
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				System.out.printf("%c",board[r][c]);
			}
			System.out.println();
		}
//		System.out.println("\n\n------------------\n\n");
	}

	static void animateBoard(char[][] board) {
		System.out.print("[0;0H\n");
		for (int row = 0; row < board.length ; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
	    delay(1000);
	}  // end animateBoard()

	/*
	set the cell (r,c) to value
	*/
	public static void setCell(char[][] board, int r, int c, char val){
		if (r>=0 && r<board.length && c>=0 && c<board[r].length){
			board[r][c] = val;
		}
	}


	/*
	Count and return the number of living neigbords around board[r][c]

	approach 1 - lots of if statements
	approach 2 - you can loop over the grid from board[r-1][c-1]
	to board[r+1][c+1]
	*/
	public static int countNeighbours(char[][] board, int r, int c){
		return 0;
	}

	/*
	given a board and a cell, determine, based on the rules for
	Conway's GOL if the cell is alive ('X') or dead (' ') in the
	next generation.

	*/
	public static char getNextGenCell(char[][] board,int r, int c){
		// calculate the number of living neighbors around board[r][c]

		// determine if board[r][c] is living or dead
		//    if living and 2 3 neighbors then remain alive
		//    if dead and 3 neighbors then become alive

		return ' ';
	}
	/*
	scan the board to generate a NEW board with the
	next generation
	*/
	public char[][] generateNextBoard(char[][] board){
		char newBoard[][] = new char[25][25];
		// fill the new board
		return newBoard;
	}

	public static void main(String[] args) {
		char[][] board;
		board = createNewBoard(25,25);
		printBoard(board)
		;

	}
}
