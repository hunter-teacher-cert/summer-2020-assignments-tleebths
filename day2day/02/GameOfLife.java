import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		// set up game board
		boolean[][] board = seed0();  // alive or dead
		
		printBoard(board);
		System.out.println("After each term, you can press [Enter] to continue, or [a-z] to quit.");

		playGame(board);
	}  // end main
	
	public static boolean[][] seed0() {
		int rows = 10, columns = 10;
		boolean[][] board = new boolean[rows][columns];
		
		for (int r=0; r<rows; r++) {
			for (int c=0; c<columns; c++) {
				board[r][c] = Math.random() < 0.5? true: false;
			}
		}  // end outer for
	
		return board;
	}  // end seed0();
	
	public static boolean[][] seed2() {
		boolean[][] board = new boolean[][] {
			{false, false, false, false, false, false, false, false, false, false},
			{false, false, false, true, false, false, false, false, false, false},
			{false, false, false, false, true, false, false, false, false, false},
			{false, false, true, true, true, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false},
			{false, false, false, false, false, false, false, false, false, false}
		};

		return board;
	}  // end seed()
		
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
		//System.out.println("entering tick");
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
		//System.out.println("entering check");
		int counter = 0;  // how many alive
		
		// add up the 9 cells incl. board[r][c], then subtract that cell
		for(int row = r-1; row < r+2; row++) {
			for(int col = c-1; col < c+2 && row > -1 && row < board.length; col++) {
				// make sure c is in bounds too
				if (col > -1 && col < board[row].length)
					counter += board[row][col]? 1: 0;
			}
		}
		counter -= board[r][c]? 1: 0;  // overcounted the cell we're examining
		
		//System.out.println("counter = " + counter);
		return (board[r][c] && (counter == 2 || counter == 3)) || (!board[r][c] && counter == 3);
			
	}

	// prints x for alive, o for dead
	public static void printBoard(boolean[][] board) {
		for (int r=0; r < board.length; r++) {
			for (int c=0; c < board[r].length; c++) {
				if (board[r][c])
					System.out.print(Color.GREEN_BOLD_BRIGHT + "X " + Color.RESET);
				else
					System.out.print("O ");
				
			}  // end for c
			
			System.out.println();
		}  // end for r
	}
	
	public static boolean[][] seed1() {
		boolean[][] board = new boolean[][] {
			{false, false, false, false, false},
			{false, false, true, false, false},
			{false, false, true, false, false},
			{false, false, true, false, false},
			{false, false, false, false, false}
		};

		return board;
	}  // end seed()

	enum Color {
		RESET("\033[0m"),
		RED_BOLD("\033[1;31m"),     // RED
		GREEN_BOLD("\033[1;32m"),   // GREEN
		// High Intensity
		RED_BRIGHT("\033[0;91m"),       // RED
		GREEN_BRIGHT("\033[0;92m"),     // GREEN
		// Bold High Intensity
		RED_BOLD_BRIGHT("\033[1;91m"),      // RED
		GREEN_BOLD_BRIGHT("\033[1;92m");    // GREEN

		private final String code;

		Color(String code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return code;
		}
	}  // end enum Color

}  // end class