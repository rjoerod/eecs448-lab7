package classFiles;
import java.io.*;
import java.nio.CharBuffer;

public class Main {
	public static void main(String[] args) {
		// Confirm command-line parameters
		if (args.length < 3)
		{
			System.out.println("Error - Expected usage: ./main input.txt output.txt");
		}
		
		// initialize file stream
		try {
			FileReader in = new FileReader(args[1]);
			FileWriter out = new FileWriter(args[2]);
			
			// Process commands
			int n;
			CharBuffer buffer;
			String line;
			while ( (in.read(buffer)) != -1 )
			{
				line = buffer.toString();
				// read size of matrix
				n = Integer.parseInt(line);
				// break out of loop if n is not a valid size of matrix
				if(n <= 0) {
					break;
				}
				
				Matrix m = new Matrix(n);
				// read all inputs to  matrix
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						in.read(buffer);
						line = buffer.toString();
						// read size of matrix
						m.addElement(Integer.parseInt(line), i, j);
					}
				}
				
				out.write("M = ");
				out.write("\n");
				// write all outputs from  matrix
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						out.write(   Double.toString( m.returnElement(i, j) )   );
					}
					out.write("\n");
				}
				out.write("\n");
				
				double det = m.determinant();
				out.write("det(M) = "); 
				out.write(det);
				out.write("\n\n");
				
				if (det != 0)
				{
					Matrix inv = m.inverse();

					out.write("Minv = ");
					out.write("\n");
					out.write(inv);
					out.write("\n");
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error:");
			System.out.println(e);
		}
	}
}
