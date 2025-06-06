import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardGUI extends JPanel implements KeyListener, ActionListener {
    protected Tile[][] tiles;
    private Board board;
    private Color[] colors;
    Timer t; // used for bot
    //SimpleAudioPlayer bgTheme = new SimpleAudioPlayer("classic.wav", true);
    protected JTextField inputField;
    protected JButton submitButton;
    
    protected Color colorCorrectSpot;
    protected Color colorWrongSpot;
    protected Color colorNotInWord;
    protected Color backgroundColor; 
    

//    public BoardGUI(String string, Color color) {
//        tiles = new Tile[6][5];
//        colors = new Color[20];
//        t = new Timer(1000, this);
//        // Colors initialized in setup()
//        setup(new String(), colors[2]);
//        t.start(); // came from 2048 game don't know if we need this
//    }

    public BoardGUI(String answer) {
    	tiles = new Tile[6][5];
        colors = new Color[20];
        t = new Timer(1000, this);
        //bgTheme.play();
        // Colors initialized in setup()
        setup(answer);
        t.start(); // calls a method every second
        
    }

   




	public void setup(String answer) {
        JFrame frame = new JFrame("SRL's Wordle");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);

        // Initialize inputField and submitButton before use
        inputField = new JTextField(5);
        submitButton = new JButton("Submit");

        // Set layout for this JPanel (BoardGUI)
        this.setLayout(new BorderLayout());

        // Create tiles panel
        JPanel tilePanel = new JPanel(new GridLayout(6, 5));

        Font bigFont = new Font("Serif", Font.BOLD, 55);

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j] = new Tile();
                tiles[i][j].setSize(100, 100);
                tiles[i][j].setFont(bigFont);
                tiles[i][j].setHorizontalAlignment(JTextField.CENTER);
                tilePanel.add(tiles[i][j]);
            }
        }

        // Add tiles panel to this JPanel center
        this.add(tilePanel, BorderLayout.CENTER);

        // Create input panel with inputField and submitButton
        JPanel inputPanel = new JPanel();
        inputField.setFont(new Font("Serif", Font.BOLD, 36));
        inputPanel.add(inputField);
        inputPanel.add(submitButton);

        // Add input panel to this JPanel south
        this.add(inputPanel, BorderLayout.SOUTH);

        // Initialize colors here (only once)
        colorCorrectSpot = new Color(106, 170, 100);  // green
        colorWrongSpot = new Color(201, 180, 88);     // yellow
        colorNotInWord = new Color(120, 124, 126);    // gray

        // Add action listeners
        submitButton.addActionListener(e -> submitGuess());

        inputField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitGuess();
                }
            }
        });

        // Initialize board
        board = new Board(answer);

        // Add this JPanel (BoardGUI) to frame
        frame.add(this);

        frame.setVisible(true);
        inputField.requestFocus();
    }
    
   

    private void submitGuess() {
        String guess = inputField.getText().toUpperCase().trim();
        if (!board.isValidGuess(guess)) {
            JOptionPane.showMessageDialog(this, "Guess must be exactly " + Board.cols + " letters.");
            return;
        }
        if (board.gameOver()) {
            JOptionPane.showMessageDialog(this, "Game over! The word was: " + board.getAnswer());
            return;
        }

        int row = board.getCurrentRow();
        board.setGuess(row, guess.toCharArray());

        // Initially set all tiles to "not in word" color
        for (int c = 0; c < Board.cols; c++) {
            tiles[row][c].setLetter(guess.charAt(c));
            tiles[row][c].setColor(colorNotInWord);
        }

        boolean[] answerUsed = new boolean[Board.cols];
        String answer = board.getAnswer();

        // First pass - correct spot (green)
        for (int c = 0; c < Board.cols; c++) {
            if (guess.charAt(c) == answer.charAt(c)) {
                tiles[row][c].setColor(colorCorrectSpot);
                answerUsed[c] = true;
            }
        }

        // Second pass - wrong spot but in word (yellow)
        for (int c = 0; c < Board.cols; c++) {
            // Skip already green tiles
            if (tiles[row][c].getBackground().equals(colorCorrectSpot)) continue;
            char ch = guess.charAt(c);
            boolean found = false;
            for (int i = 0; i < Board.cols; i++) {
                if (!answerUsed[i] && answer.charAt(i) == ch) {
                    found = true;
                    answerUsed[i] = true;
                    break;
                }
            }
            if (found) {
                tiles[row][c].setColor(colorWrongSpot);
            } else {
                tiles[row][c].setColor(colorNotInWord);
            }
        }

        if (board.checkWin(row)) {
            JOptionPane.showMessageDialog(this, "Congratulations! You guessed the word!");
            inputField.setEditable(false);
            submitButton.setEnabled(false);
        } else {
            board.nextRow();
            if (board.gameOver()) {
                JOptionPane.showMessageDialog(this, "Game over! The word was: " + answer);
                inputField.setEditable(false);
                submitButton.setEnabled(false);
            }
        }

        inputField.setText("");
        inputField.requestFocus();
    }

    // Required by ActionListener interface, no current usage
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    // KeyListener methods (empty since you're using KeyAdapter)
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
