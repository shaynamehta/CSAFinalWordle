import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnimalGUI extends BoardGUI {

	
	public AnimalGUI() {
		super(getAnimalWord());;
        applyTheme();
    }

    private static String getAnimalWord() {
		// TODO Auto-generated method stub
    	String answer = "";
    	File words = new File("AnimalWords");
		
		
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
		System.out.println(answer);
		return answer;
	}

	private void applyTheme() {
        Color pastelGreen = new Color(152, 251, 152);
        Color pastelYellow = new Color(255, 250, 205);
        Color pastelGray = new Color(211, 211, 211);

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j].setBackground(pastelGray);
                tiles[i][j].setForeground(Color.DARK_GRAY);
            }
        }
        inputField.setBackground(pastelYellow);
        inputField.setForeground(Color.DARK_GRAY);
        submitButton.setBackground(pastelGreen);
        submitButton.setForeground(Color.DARK_GRAY);
        this.setBackground(new Color(255, 245, 238)); // seashell pastel
    }
}


