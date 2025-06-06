import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnimalGUI extends BoardGUI {
	//setting up background audio
	SimpleAudioPlayer bgTheme = new SimpleAudioPlayer("animal.wav", true);
	
	public AnimalGUI() {
		//extracting from file
		super(getAnimalWord());;
        applyTheme();
        bgTheme.play();
	//color
        colorCorrectSpot = new Color(35, 101, 51);  
        colorWrongSpot = new Color(218, 244, 40);    
        colorNotInWord = new Color(153, 153, 153);   
        backgroundColor = new Color(800080);
    }

    private static String getAnimalWord() {
		// TODO Auto-generated method stub
    	String answer = "";
	//file text
    	File words = new File("AnimalWords");
		
		
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
		System.out.println(answer);
		return answer;
	}

	private void applyTheme() {
	//applying the colors
        Color pastelGreen = new Color(152, 251, 152);
        Color pastelYellow = new Color(255, 250, 205);
        Color pastelGray = new Color(211, 211, 211);
        Color orange = new Color(255, 165, 0);

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j].setBackground(Color.ORANGE);
                tiles[i][j].setForeground(Color.DARK_GRAY);
            }
        }
	//inputting everything
        inputField.setBackground(pastelYellow);
        inputField.setForeground(Color.DARK_GRAY);
        submitButton.setBackground(pastelGreen);
        submitButton.setForeground(Color.DARK_GRAY);
        this.setBackground(new Color(255, 245, 238)); // seashell pastel
    }
}


