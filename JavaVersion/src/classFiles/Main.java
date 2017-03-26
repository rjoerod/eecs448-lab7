package classFiles;
import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// Confirm command-line parameters
		if (args.length < 2)
		{
			System.out.println("Error - Expected usage: ./main input.txt output.txt");
			System.exit(0);
		}
		
		// initialize file stream
		try {
			File in = new File(args[0]);
			Scanner scanner = new Scanner(in);
			FileWriter out = new FileWriter(args[1]);

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
				
				// read all inputs to  matrix
				Matrix m = new Matrix(n);
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {

						// read size of matrix
						m.addElement(scanner.nextInt(), i, j);
					}
				}
				
				// write all elements from  matrix
				out.write("M = ");
				out.write("\r\n");
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						out.write(   Double.toString( m.returnElement(i, j) )   );
						out.write(" ");
					}
					out.write("\r\n");
				}
				out.write("\r\n");
				
				// write determinant of matrix
				double det = m.determinant();
				out.write("det(M) = "); 
				out.write( Double.toString(det) );
				out.write("\r\n\r\n");
				
				// write all elements from inverse of matrix
				if (det != 0)
				{
					Matrix inv = m.inverse();
					out.write("Minv = ");
					out.write("\r\n");
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < n; j++) {
							out.write(   Double.toString( inv.returnElement(i, j) )   );
							out.write(" ");
						}
						out.write("\r\n");
					}
					out.write("\r\n");
				}
			} // END While
			
			out.write("Done!");
			scanner.close();
			out.close();
			
		} // END Try
		catch (Exception e) {
			System.out.println("Error:");
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
