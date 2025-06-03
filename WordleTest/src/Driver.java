
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] data = new String[5][6];

		BoardGUI b = new BoardGUI(data); //need to adjust to our project
		
		FileRead a = new FileRead();
		FileRead bb = new FileRead("animals");
		a.Tester();
	}

}
