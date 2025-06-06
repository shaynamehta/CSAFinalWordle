import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LocationsGUI extends BoardGUI {

	public LocationsGUI() {
        super(getLocationsWord());
        applyTheme();
        colorCorrectSpot = new Color(102, 204, 255);  // light blue
        colorWrongSpot = new Color(153, 255, 204);    // mint
        colorNotInWord = new Color(200, 200, 255);  
    }

    private static String getLocationsWord() {
    	String answer = "";
    	File words = new File("CityAndCountryWords");
		
		
		try {
			Scanner scan = new Scanner(words);
			
			for (int i = 0 ; i < Math.random()*10 + 1 ; i++) {
				
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

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j].setBackground(darkGray);
                tiles[i][j].setForeground(Color.DARK_GRAY);
            }
        }
        inputField.setBackground(darkYellow);
        inputField.setForeground(Color.DARK_GRAY);
        submitButton.setBackground(darkGreen);
        submitButton.setForeground(Color.DARK_GRAY);
        this.setBackground(new Color(255, 245, 238)); // seashell pastel
    }
}






