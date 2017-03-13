#include "Matrix.h"
#include <cmath>

using namespace std;

Matrix::Matrix(int _n) : n(_n)
{ }

double Matrix::determinant()
{
	double det = 0.0;
	
	if (n == 1)
	{
		det = mdata[0][0];
	}
	else if (n == 2)
	{
		det = mdata[0][0] * mdata[1][1] - mdata[0][1] * mdata[1][0];
	}
	else
	{
		for (int i = 0; i < n; ++i)
		{
			det += pow(-1.0, (double)i) * mdata[0][i] * subMatrix(0, i).determinant();
		}
	}
	
	return det;
}

Matrix Matrix::inverse()
{
	Matrix inv(n);
	double det = determinant();
	
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			inv.mdata[i][j] = pow(-1.0, (double)i + j) * subMatrix(j, i).determinant() / det;
		}
	}
	
	return inv;
}

Matrix Matrix::subMatrix(int r, int c)
{
	Matrix sub(n - 1);
	
	int row = 0; 
	for (int i = 0; i < n; ++i)
	{
		if (i == r) continue;
		
		int col = 0;
		for (int j = 0; j < n; ++j)
		{
			if (j == c) continue;
			
			sub.mdata[row][col] = mdata[i][j];
			++col;
		}
		
		++row;
	}
	
	return sub;
}
