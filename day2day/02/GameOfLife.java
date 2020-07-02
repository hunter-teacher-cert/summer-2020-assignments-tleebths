import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		boolean[][] board;

		// set up game board, alive or dead
		if (args.length==0) {
			board = seed0();
		} else {
			char c = args[0].charAt(0);
			switch (c) {
				case '1': board = seed1();
					 break;
				case '2': board = seed2();
					 break;
				default:
					board = seed0();
			}
		}

		for (int i=0; i<300; i++)  // clear screen
			System.out.println();

		//printBoard(board);
		//System.out.println("After each turn,  press [Enter] to continue, or [a-z] to quit.\n");
		//playGame(board);

		while (true) {
			animateBoard(board);
			board = tick(board);
		}

	}  // end main

	// simple infinite loop pattern 1, wiki page
	public static boolean[][] seed1() {
		boolean[][] board = new boolean[][] {
			{false, false, false, false, false},
			{false, false, true, false, false},
			{false, false, true, false, false},
			{false, false, true, false, false},
			{false, false, false, false, false}
		};

		return board;
	}  // end seed1()

	// random board
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

	// repeats ticks until user wants to stop with lowercase letter
	// prints board after each tick
	public static void playGame(boolean[][] board) {
		Scanner scan = new Scanner(System.in);
		String s;
		char c = '0';  // initialized to not a stopping condition

		while (c < 'a' || c > 'z') {
			board = tick(board);
			//printBoard(board);
			animateBoard(board);

			// check if player wants to continue
			s = scan.nextLine();
			if (!s.isEmpty())  // player doesn't have to enter anything
				c = s.charAt(0);

		}  // end while

	}  // end playGame()

	static void animateBoard(boolean[][] board) {
		System.out.print("\033[0;0H");
		for (int row = 0; row < board.length ; row++) {
			for (int col = 0; col < board[row].length; col++) {
				String s = board[row][col] ? Color.GREEN_BOLD_BRIGHT + "X " + Color.RESET : " ";
				System.out.print(s);
			}
			System.out.println();
		}
	    delay(500);
	}  // end animateBoard()

	// Returns new board after one tick (one update)
	public static boolean[][] tick(boolean[][] board) {
		//System.out.println("entering tick");
		// Set up a second board to not mess up current state, same dimensions
		boolean[][] newBoard = new boolean[board.length][board[0].length];

		for (int r=0; r < board.length; r++) {
			for (int c=0; c < board[r].length; c++) {
				newBoard[r][c] = check(board, r, c);
			}  // end for c
		}  // end for r

		return newBoard;
	}  // end tick()

	/* Apply rules of Conway's Game of Life
	 * Any live cell with two or three live neighbours survives.
     * Any dead cell with three live neighbours becomes a live cell.
     * All other live cells die in the next generation. Similarly, all other dead cells stay dead.
	 */
	private static boolean check(boolean[][] board, int r, int c) {
		//System.out.println("entering check");
		int counter = 0;  // how many alive

		// add up the up to 9 cells incl. target, then subtract that cell
		for(int row = r-1; row < r+2; row++) {
			for(int col = c-1; col < c+2 && row > -1 && row < board.length; col++) {
				// make sure c is in bounds too
				if (col > -1 && col < board[row].length)
					counter += board[row][col]? 1: 0;  // ternary operator (if-then-else)
			}
		}

		counter -= board[r][c]? 1: 0;  // overcounted the cell we're examining

		//System.out.println("counter = " + counter);
		return (board[r][c] && (counter == 2 || counter == 3)) || (!board[r][c] && counter == 3);

	}

	// prints X for alive, O for dead
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

	// spaceship 1, wiki page
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

	//helper method to slow down animation
	public static void delay(int n)
	{
		try {
			Thread.sleep(n);
		}
		catch(InterruptedException e) {}
	}

	// Make it pop
	enum Color {
		RESET("\033[0m"),
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
