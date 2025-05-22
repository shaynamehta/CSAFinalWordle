import java.util.Random;

import javax.xml.crypto.Data;

public class Board {
 
	private int[][] board; // holds state of game
	//private Random rnd = new Random(0);
	private String[] answer; 
	
	//unchanged from 2048 can see if we need to tweak it
	//What instance variable can you add to keep track of the size or the number of tiles occupied?
	private int size = 0; //number of tiles occupied
	
	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {
		
		// instantiate the board
		board = new int[5][5];
		//answer = FileRead.getAnswer();  //method to be written in FileRead class 
										//(need to check if this is the best way to do so) 
										//since we need user input to choose theme maybe do the file reading/answer 
										//setting in a different class?
	}//

	/*
	 * return a String representation of the 2D array board
	 * each row should be in its own line
	 * 
	 * Example:
	 * 
	 * { {1, 2, 3}, {4, 5, 6}} -> 1 2 3
	 * 
	 * 4 5 6
	 */

	
	// overriding a method is when a "child"
	// class implement the exact same method
	// that its parent class has
	public String toString() {
		
		
		/*
		 * Use the String formatter to pad the numbers with leading 0s
		 * so that the print out does not become jagged
		 * An example is shown below. 
		 * String str = String.format("%04d", 9);  // 0009  
		 * int x = 30;
		 * System.out.println(String.format("%04d",x));
		 *     
		 */
		
		//2D array traversal 
		//write the nested for loop for printing 
		
		
		String result = ""; //where to build numbers
		for (int row = 0 ; row < board.length ; row++) {
			
			//for loop to traverse row
			for (int col = 0 ; col < board[row].length ; col++) {
				
				String formatted = String.format("%04d", board[row][col]); //format the num so it has leading zeroes
				
				result += formatted + " ";
				
			}
			//add a new line character after each row 
			result += "\n"; 
		}
		
		//setup loops to visit
		//every spot possible
		
		
		
		return result;
	}

	
	
	//game ends when all 5 chances are used OR the wordle is guessed correctly
	public boolean gameOver() {
		return false;
	}

	public int[][] getBoard() {
		return board;
	}

	// populate with a given 2d array
	public void populate(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				board[r][c] = arr[r][c];
			}
		}
	}

}
