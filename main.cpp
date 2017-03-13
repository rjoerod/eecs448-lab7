#include <iostream>
#include <fstream>
#include "Matrix.h"

using namespace std;

int main(int argc, char* argv[])
{
	// Confirm command-line parameters
	if (argc < 3)
	{
		cerr << "Error - Expected usage: ./main input.txt output.txt" << endl;
		return 1;
	}
	
	// Initialize file streams
	ifstream in(argv[1]);
	ofstream out(argv[2]);
	
	// Process commands
	int n;
	while (in >> n && n > 0)
	{
		Matrix m(n);
		in >> m;
		
		out << "M = " << endl;
		out << m << endl;
		
		double det = m.determinant();
		out << "det(M) = " << det << endl << endl;
		
		if (det != 0)
		{
			Matrix inv = m.inverse();

			out << "Minv = " << endl << inv << endl;
		}
	}
	
	return 0;
}
