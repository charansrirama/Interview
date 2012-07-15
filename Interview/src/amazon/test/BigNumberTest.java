package amazon.test;

import static org.junit.Assert.*;

import org.junit.Test;

import amazon.BigNumber;


public class BigNumberTest {

	@Test
	public void testAdd() {
		BigNumber addTest = new BigNumber();
		assertEquals("Add Result: ", "10", addTest.add("5", "5"));
		assertEquals("Add Result: ", "0", addTest.add("0", "0"));
		assertEquals("Add Result: ", "1000", addTest.add("999", "1"));
	}
	
	@Test
	public void testMinus() {
		BigNumber minusTest = new BigNumber();
		assertEquals("Minus Result: ", "10", minusTest.minus("20", "10"));
//		assertEquals("Minus Result: ", "199", minusTest.minus("200", "1"));
//		assertEquals("Minus Result: ", "-10", minusTest.minus("0", "10"));
	}

	@Test
	public void testMultipy() {
		BigNumber multipyTest = new BigNumber();
		assertEquals("Multipy Result: ", "0", multipyTest.multipy("0", "100"));
		assertEquals("Multipy Result: ", "0", multipyTest.multipy("10", "0"));
		assertEquals("Multipy Result: ", "2000", multipyTest.multipy("20", "100"));
		assertEquals("Multipy Result: ", "121", multipyTest.multipy("11", "11"));
	}
}
