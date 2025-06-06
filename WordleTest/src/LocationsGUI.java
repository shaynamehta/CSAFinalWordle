import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LocationsGUI extends BoardGUI {
	//background audio
	SimpleAudioPlayer bgTheme = new SimpleAudioPlayer("location.wav", true);
	
	public LocationsGUI() {
        super(getLocationsWord());
        bgTheme.play();
        applyTheme();
	//colors for right, wrong, right but wrong, background color
        colorCorrectSpot = new Color(35, 101, 51);  
        colorWrongSpot = new Color(218, 244, 40);    
        colorNotInWord = new Color(153, 153, 153);  
        backgroundColor = new Color(800080);
    }

    private static String getLocationsWord() {
    	String answer = "";
    	File words = new File("CityAndCountryWords");
		
		
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

 
	//colors
	private void applyTheme() {
        Color darkGreen = new Color(2, 48, 32);
        Color darkYellow = new Color(255, 174, 66);
        Color darkGray = new Color(211, 211, 211);
        //Color purple = new Color(128, 0 , 128);

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j].setBackground(Color.PINK);
                tiles[i][j].setForeground(Color.DARK_GRAY);
            }
        }
	//inputting everything
        inputField.setBackground(darkYellow);
        inputField.setForeground(Color.DARK_GRAY);
        submitButton.setBackground(darkGreen);
        submitButton.setForeground(Color.DARK_GRAY);
	//background
        this.setBackground(new Color(255, 245, 238)); // seashell pastel
    }
}






