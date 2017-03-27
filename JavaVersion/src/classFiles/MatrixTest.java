package classFiles;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testDeterminant() {
		
		// initialize new matrix
		Matrix mTest = new Matrix(3);
		
		// add elements
		mTest.addElement(2,0,0);
		mTest.addElement(2,0,1);
		mTest.addElement(0,0,2);
		
		mTest.addElement(5,1,0);
		mTest.addElement(1,1,1);
		mTest.addElement(4,1,2);
		
		mTest.addElement(8,2,0);
		mTest.addElement(0,2,1);
		mTest.addElement(0,2,2);
		
		// test if determinant is 64.0
		assertEquals( 64.0, mTest.determinant(), 0.001 );
		
	}

	@Test
	public void testInverse() {
		
		// initialize new matrix
		Matrix mTest = new Matrix(3);
		
		// add elements
		mTest.addElement(2,0,0);
		mTest.addElement(2,0,1);
		mTest.addElement(0,0,2);
		
		mTest.addElement(5,1,0);
		mTest.addElement(1,1,1);
		mTest.addElement(4,1,2);
		
		mTest.addElement(8,2,0);
		mTest.addElement(0,2,1);
		mTest.addElement(0,2,2);
		
		// initialize inverse matrix
		Matrix mTestInverse = new Matrix(3);
		
		// add elements
		mTestInverse.addElement(0,0,0);
		mTestInverse.addElement(0,0,1);
		mTestInverse.addElement(0.125,0,2);
		
		mTestInverse.addElement(0.5,1,0);
		mTestInverse.addElement(0,1,1);
		mTestInverse.addElement(-0.125,1,2);
		
		mTestInverse.addElement(-0.125,2,0);
		mTestInverse.addElement(0.25,2,1);
		mTestInverse.addElement(-0.125,2,2);
		
		// test if inverse of mTest is mTestInverse
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				assertEquals( mTestInverse.returnElement(i,j), (mTest.inverse()).returnElement(i,j), 0.001 );
			}
		}	
	}

	@Test
	public void testSubMatrix() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnElement() {
		fail("Not yet implemented");
	}

}
