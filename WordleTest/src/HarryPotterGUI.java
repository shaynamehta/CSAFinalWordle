import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HarryPotterGUI extends BoardGUI {
	
	SimpleAudioPlayer bgTheme = new SimpleAudioPlayer("HPTheme.wav", true);
	 Color background = new Color(800080); 
	
	public HarryPotterGUI() {
		super(getPotterWord());
		bgTheme.play();
		applyTheme();
        
        colorCorrectSpot = new Color(35, 101, 51);  
        colorWrongSpot = new Color(218, 244, 40);    
        colorNotInWord = new Color(153, 153, 153);  
        backgroundColor = new Color(800020);
    }

	
	
    private static String getPotterWord() {
    	String answer = "";
    	File words = new File("Harry Potter");
		
		
		try {
			Scanner scan = new Scanner(words);
			
			for (int i = 0 ; i < Math.random()*40 + 1 ; i++) {
				
				scan.nextLine();
				answer = scan.nextLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(answer);
		return answer;
	}

	private void applyTheme() {
        Color darkGreen = new Color(2, 48, 32);
        Color darkYellow = new Color(255, 174, 66);
        Color darkGray = new Color(211, 211, 211);

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j].setBackground(Color.red);
                tiles[i][j].setForeground(Color.DARK_GRAY);
            }
        }
        inputField.setBackground(Color.LIGHT_GRAY);
        inputField.setForeground(Color.DARK_GRAY);
        submitButton.setBackground(darkGreen);
        submitButton.setForeground(Color.DARK_GRAY);
        this.setBackground(new Color(255, 245, 238)); // seashell pastel
    }
}






