package classFiles;
import java.io.*;
import java.nio.CharBuffer;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Confirm command-line parameters
		if (args.length < 2)
		{
			System.out.println("Error - Expected usage: ./main input.txt output.txt");
			System.exit(0);
		}
		
		// setting up input file directory
		String fileInput = ""; 
		fileInput += System.getProperty("user.dir");
		fileInput += "\\";
		fileInput += args[0];
		
		System.out.println(fileInput);
		System.out.println(args[1]);		
		
		// initialize file stream
		try {
			File in = new File(fileInput);
			Scanner scanner = new Scanner(in);
			FileWriter out = new FileWriter(args[1]);
			System.out.println("Process commands");
			// Process commands
			int n;
			while ( true )
			{
				
				// read size of matrix
				n = scanner.nextInt();
				// break out of loop if n is not a valid size of matrix
				if(n <= 0) {
					break;
				}
				System.out.println("read all inputs to  matrix");
				Matrix m = new Matrix(n);
				// read all inputs to  matrix
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {

						// read size of matrix
						m.addElement(scanner.nextInt(), i, j);
					}
				}
				
				out.write("M = ");
				out.write("\n");
				// write all elements from  matrix
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						out.write(   Double.toString( m.returnElement(i, j) )   );
					}
					out.write("\n");
				}
				out.write("\n");
				
				// write determinant of matrix
				double det = m.determinant();
				out.write("det(M) = "); 
				out.write( Double.toString(det) );
				out.write("\n\n");
				
				// write all element from determinant of matrix
				if (det != 0)
				{
					Matrix inv = m.inverse();

					out.write("Minv = ");
					out.write("\n");
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < n; j++) {
							out.write(   Double.toString( inv.returnElement(i, j) )   );
						}
						out.write("\n");
					}
					out.write("\n");
				}
			}
			scanner.close();
			out.close();
		}
		catch (Exception e) {
			System.out.println("Error:");
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
