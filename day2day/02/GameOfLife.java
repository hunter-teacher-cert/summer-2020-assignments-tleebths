import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		// set up game board
		int rows = 10, columns = 10;
		boolean[][] board = new boolean[rows][columns];  // alive or dead
		
		System.out.println("After each term, you can press [Enter] to continue, or [a-z] to quit.");

		playGame(board);
	}  // end main

	// repeats ticks until user wants to stop
	public static void playGame(boolean[][] board) {
		Scanner scan = new Scanner(System.in);
		String s;
		char c = '0';  // initialized to not a stopping condition
		
		while (c < 'a' || c > 'z') {
			board = tick(board);
			printBoard(board);
			
			// check if player wants to continue
			s = scan.nextLine();
			if (!s.isEmpty())
				c = s.charAt(0);

		}  // end while
		
	}  // end playGame()

	// Returns new board after one tick (one update)
	public static boolean[][] tick(boolean[][] board) {
		// Set up a second board to not mess up current state, same dims
		boolean[][] newBoard = new boolean[board.length][board[0].length];
		
		for (int r=0; r < board.length; r++) {
			for (int c=0; c < board[r].length; c++) {
				newBoard[r][c] = check(board, r, c);
		
			}  // end for c
		}  // end for r
		
		return newBoard;
	}  // end tick()
	
	/* Rules of Conway's Game of Life
	 * Any live cell with two or three live neighbours survives.
     * Any dead cell with three live neighbours becomes a live cell.
     * All other live cells die in the next generation. Similarly, all other dead cells stay dead.
	*/
	private static boolean check(boolean[][] board, int r, int c) {
		int counter = 0;  // how many alive
		
		// add up the 9 cells incl. board[r][c], then subtract that cell
		for(int row = r-1; row < row+2; row++) {
			for(int col = c-1; col < col+2; col++) {
				counter += board[row][col]? 1: 0;
			}
		}
		counter -= board[r][c];
		
		if 
		return true;
	}

	// prints x for alive, o for dead
	public static void printBoard(boolean[][] board) {
		for (int r=0; r < board.length; r++) {
			for (int c=0; c < board[r].length; c++) {
				if (board[r][c])
					System.out.print("x ");
				else
					System.out.print("o ");
				
			}  // end for c
			
			System.out.println();
		}  // end for r
	}
	
}  // end class