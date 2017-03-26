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
			for(int i = 0; i < n; i++) {
				det += pow(-1.0, (double)i) * mdata[0][i] * subMatrix(0, i).determinant();
			}
		}
		return det;
	}
	
	public Matrix inverse() {
		
		return null;
	}
	
	public Matrix subMatrix(int i, int j) {
		return null;
		
	}
}
