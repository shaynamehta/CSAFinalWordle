import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(() -> {
			
		    // Show a dialog to select theme
		   String[] themes = { "Classic", "Animals", "Locations" , "Harry Potter"};
		   String selectedTheme = (String) JOptionPane.showInputDialog(
		   null,
		   "Choose your theme:",
		   "Theme Selection",
		   JOptionPane.QUESTION_MESSAGE,
		                null,
		                themes,
		                themes[0]
		            );

		   if (selectedTheme == null) {
			   // User canceled; exit
			   System.exit(0);
		            }

		   JFrame frame = new JFrame("SRL's Wordle Game");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setSize(400, 600);

           BoardGUI gamePanel = null;

           switch (selectedTheme) {
               case "Animals":
                   gamePanel = new AnimalGUI();
                   break;
               case "Locations":
                   gamePanel = new LocationsGUI();
                   break;
               case "Classic":
                   gamePanel = new BoardGUI(getClassicWord());
                   break;
               case "Harry Potter":
            	   gamePanel = new HarryPotterGUI();
            	   break;
           }

           frame.add(gamePanel);
           frame.setVisible(true);
       });
   }
	
	public static String getClassicWord() {
		
		String answer = "";
    	File words = new File("AllWords");
		
		
		try {
			Scanner scan = new Scanner(words);
			
			for (int i = 0 ; i < Math.random()*200 + 1 ; i++) {
				
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

}
