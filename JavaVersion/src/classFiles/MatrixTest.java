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
