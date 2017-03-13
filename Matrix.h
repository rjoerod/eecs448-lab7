#ifndef MATRIX_H
#define MATRIX_H

#include <iostream>

const int MaxSize = 10;

class Matrix
{
  private:
	int n;
	double mdata[MaxSize][MaxSize];
	
  public:
	Matrix(int _n = MaxSize);
	
	double determinant();
	Matrix inverse();
	Matrix subMatrix(int i, int j);
};

#endif
