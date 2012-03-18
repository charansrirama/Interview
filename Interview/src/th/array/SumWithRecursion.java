package th.array;

public class SumWithRecursion {
	
	//Use recursion to compute the sum of array with one line of code.
	public static int sumRecursion(int array[], int length) {
		return length == 0? 0 : sumRecursion(array, length-1) + array[length-1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[] {1,2,3,4,5,6,7};
		System.out.println(SumWithRecursion.sumRecursion(array, array.length));
	}

}
