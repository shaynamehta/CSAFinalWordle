
/*
 * ok so we have to use inheritance in the project so i'm thinking we can use it here since it's the easiest 
 * implementation 
 * we can do like an overall word bank class and then have the themes be "theme" extends WordBank so that
 * if the user selects no theme it just pulls from the main word bank and if they choose a theme it goes to the extended
 * class
 * 
 * its kinda useless but for now that's what i think is the best way to implement inheritance
 * 
 * also in this class we will turn the answer into a String array
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {

	public void Tester(){
	
	File words = new File("AnimalWords");
	String answer = "";
	
	try {
		Scanner scan = new Scanner(words);
		
		for (int i = 0 ; i < Math.random()*14 + 1 ; i++) {
			
			scan.nextLine();
			answer = scan.nextLine();
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(answer);
	}
	
}
