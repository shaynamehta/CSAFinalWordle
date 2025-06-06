import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FoodGUI extends BoardGUI {
	
	SimpleAudioPlayer bgTheme = new SimpleAudioPlayer("food.wav", true);
	
	public FoodGUI() {
        super(getFoodWord());
        bgTheme.play();
		//SimpleAudioPlayer.playInBackground("success.wav");
        applyTheme();
        colorCorrectSpot = new Color(35, 101, 51);  
        colorWrongSpot = new Color(218, 244, 40);    
        colorNotInWord = new Color(153, 153, 153);  
        backgroundColor = new Color(255, 165, 0);
    }

    private static String getFoodWord() {
    	String answer = "";
    	File words = new File("FoodAndDrinkWords");
		
		
		try {
			Scanner scan = new Scanner(words);
			
			for (int i = 0 ; i < Math.random()*15 + 1 ; i++) {
				
				scan.nextLine();
				answer = scan.nextLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answer;
	}

	private void applyTheme() {
        Color darkGreen = new Color(2, 48, 32);
        Color darkYellow = new Color(255, 174, 66);
        Color darkGray = new Color(211, 211, 211);
        Color orange = new Color(255, 165, 0);

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j].setBackground(Color.blue);
                tiles[i][j].setForeground(Color.DARK_GRAY);
            }
        }
        inputField.setBackground(Color.GREEN);
        inputField.setForeground(Color.DARK_GRAY);
        submitButton.setBackground(darkGreen);
        submitButton.setForeground(Color.DARK_GRAY);
        this.setBackground(new Color(255, 245, 238)); 
    }
}






