/*
 * ok this is where we are going to do most of our game building for the GUI and 
 * the ;ogic of the game
 * 
 * use the 2048 as somewhat of a guide to get started and then we'll figure out how to 
 * adjust it to the Wordle set up (size of 2d array), char instead of string/int, checking the string
 * 
 */

public class Board {
    private char[][] board;  // 6 rows (attempts), 5 cols (letters)
    private String answer;   // word to guess
    
    public static int rows = 6;
    public static int cols = 5;
    
    private int currentRow;

    public Board(String answer) {
        this.answer = answer.toUpperCase();
        board = new char[rows][cols];
        // initialize board with spaces
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                board[r][c] = ' ';
        currentRow = 0;
    }
    
    public char[][] getBoard() {
        return board;
    }

    public int getCurrentRow() {
        return currentRow;
    }
    
    public void setGuess(int row, char[] guess) {
        if (row < rows && guess.length == cols) {
            for (int c = 0; c < cols; c++) {
                board[row][c] = Character.toUpperCase(guess[c]);
            }
        }
    }
    
    public boolean isValidGuess(String guess) {
        return guess != null && guess.length() == cols;
    }

    public boolean checkWin(int row) {
        for (int c = 0; c < cols; c++) {
            if (board[row][c] != answer.charAt(c))
                return false;
        }
        return true;
    }

    public boolean gameOver() {
        return currentRow >= rows;
    }
    
    public void nextRow() {
        currentRow++;
    }
    
    public String getAnswer() {
        return answer;
    }
}
