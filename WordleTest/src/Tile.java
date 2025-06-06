import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

/*
 * configured from 2048 game to work for wordle
 */

public class Tile extends JLabel {
    private Color defaultBg = new Color(0xb1a395);
    private char letter = ' ';
	public int cindex = 0;

    public Tile() {
        setOpaque(true);
        setFont(new Font("Dialog", Font.BOLD, 55));
        setHorizontalAlignment(JLabel.CENTER);
        setBackground(Color.LIGHT_GRAY);
        MatteBorder border = new MatteBorder(3,3,3,3, defaultBg);
        setBorder(border);
        setText("");
    }

    public void setLetter(char c) {
        letter = c;
        if (c == ' ') {
            setText("");
        } else {
            setText(String.valueOf(c));
        }
    }

    // Set color based on correctness:
    // green: correct letter and position
    // yellow: letter in word but wrong position
    // gray: letter not in word
    public void setColor(Color c) {
        setBackground(c);
    }

    public char getLetter() {
        return letter;
    }

	public void setEditable(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
