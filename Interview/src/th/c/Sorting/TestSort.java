package th.c.Sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSort {

	private Sort sort;

	public TestSort(Sort sort) {
		this.sort = sort;
	}

	@Parameters
	public static Collection regExValues() {
		return Arrays.asList(new Object[][] { 
				{ new BubbleSort() } ,
				{ new InsertionSort() },
				{ new ShellSort() },
				{ new MergeSort() },
				{ new QuickSort() }
		});
	}

	// Null array
	@Test
	public void testNullArray() {
		sort.sort(null);
	}

	// Empty array
	@Test
	public void testEmptyArray() {
		int[] array = new int[0];
		sort.sort(array);
		Assert.assertArrayEquals(new int[0], array);
	}

	@Test
	public void testOneElement() {
		int[] array = { 42 };
		int[] test = { 42 };
		sort.sort(array);
		Assert.assertArrayEquals(test, array);
	}

	// two element array ordered
	@Test
	public void testTwoElementOrdArray() {
		int[] array = { 7, 42 };
		int[] test = { 7, 42 };
		sort.sort(array);
		Assert.assertArrayEquals(test, array);
	}

	// two element array unordered
	@Test
	public void testTwoElementUnordArray() {
		int[] array = { 42, 7 };
		int[] test = { 7, 42 };
		sort.sort(array);
		Assert.assertArrayEquals(test, array);
	}

	// odd numbered element array
	@Test
	public void testOddNoElementsArray() {
		int[] array = { 42, 68, 9, 7, 100, 36, 27 };
		int[] test = { 7, 9, 27, 36, 42, 68, 100 };
		sort.sort(array);
		Assert.assertArrayEquals(test, array);
	}

	// even numbered element array
	@Test
	public void testEvenNoElementsArray() {
		int[] array = { 42, 68, 9, 7, 100, 36, 27, 99 };
		int[] test = { 7, 9, 27, 36, 42, 68, 99, 100 };
		sort.sort(array);
		Assert.assertArrayEquals(test, array);
	}

	// array in reverse order
	@Test
	public void testReverseOrder() {
		int[] array = { 100, 99, 68, 42, 36, 27, 9, 7 };
		int[] test = { 7, 9, 27, 36, 42, 68, 99, 100 };
		sort.sort(array);
		Assert.assertArrayEquals(test, array);
	}

	// Longer array
	@Test
	public void testLongerArray() {
		int[] array = { 13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25,
				39, 10 };
		int[] test = { 10, 13, 14, 23, 25, 25, 27, 33, 39, 45, 59, 65, 73, 82,
				94, 94 };
		sort.sort(array);
		Assert.assertArrayEquals(test, array);
	}

}
