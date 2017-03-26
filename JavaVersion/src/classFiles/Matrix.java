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
	public double determinant() {
		double det = 0.0;
		
		// condition: size of matrix
		if(n == 1) {
			det = mdata[0][0];
		}
		else if(n == 2) {
			det = mdata[0][0] * mdata[1][1] - mdata[0][1] * mdata[1][0];
		}
		else {
			for(int i = 0; i < n; i++) {
				det += Math.pow(-1.0, (double)i) * mdata[0][i] * subMatrix(0, i).determinant();
			}
		}
		return det;
	}
	
	// returns inverse of the matrix
	public Matrix inverse() {
		
		Matrix inv = new Matrix(n);
		double det = determinant();
		
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				inv.mdata[i][j] = Math.pow(-1.0, (double)i + j) * subMatrix(j, i).determinant() / det;
			}
		}
		
		return inv;
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
	
	// adds an element to the matrix
	public void addElement(int element, int r, int c) {
		if( (r >= 0) && (c >= 0) && (r < n) && (c < n) ) {
			mdata[r][c] = element;
		}
	}

	// returns an element from the matrix
	public double returnElement(int r, int c) {
		if( (r >= 0) && (c >= 0) && (r < n) && (c < n) ) {
			return mdata[r][c];
		}
		else {
			throw new RuntimeException("Invalid Row/Column");
		}
	}	
}
