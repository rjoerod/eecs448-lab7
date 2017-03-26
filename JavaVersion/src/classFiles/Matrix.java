package classFiles;
import java.lang.Math;

// A matrix with equal rows and columns
public class Matrix {
	
	private int MaxSize = 10;
	
	private int n; // size of matrix
	private double[][] mdata = new double[MaxSize][MaxSize]; // matrix representation
	
	
	// constructor
	public Matrix(int _n) {
		n = _n;
	}
	
	// returns the determinant of the matrix
	public double Determinant() {
		double det = 0.0;
		
		// condition: size of matrix
		if(n == 1) {
			det = mdata[0][0];
		}
		else if(n == 2) {
			det = mdata[0][0] * mdata[1][1] - mdata[0][1] * mdata[1][0];
		}
		else {

		}
		return det;
	}
	
	public Matrix inverse() {
		
		return null;
	}
	
	// returns submatrix to given param where r is row and c is columns
	public Matrix subMatrix(int r, int c) {
		
		Matrix sub = new Matrix(n-1);
		
		int row = 0;
		for(int i = 0; i < n; i++) {
			if (i == r) continue;
			
			int col = 0;
			for(int j = 0; j < n; j++) {
				if(j == c) continue;
				
				sub.mdata[row][col] = mdata[i][j];
				col++;
			}
			row++;
		}
		return sub;
	}
}
