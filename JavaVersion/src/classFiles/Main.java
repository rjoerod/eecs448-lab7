package classFiles;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		// Confirm command-line parameters
		if (args.length < 3)
		{
			System.out.println("Error - Expected usage: ./main input.txt output.txt");
		}
		
		// initialize file stream
		try {
			FileInputStream in = new FileInputStream(args[1]);
			FileOutputStream out = new FileOutputStream(args[2]);
		}
		catch (Exception e) {
			System.out.println("Error - File Not found");
		}
		
	}
}
