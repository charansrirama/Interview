package th.c.codility;

/*
 * count the number of elements in an array a which are 
 * absolute distinct, what it means is if an array 
 * had -3 and 3 in it these numbers are not distinct 
 * because|-3|=|3|. 
 */
public class DistinctCount {

	public static int countDistinct(int[] array) {
		if (array.length == 0 || array == null)
			return 0;
		int result = 0;
		int start = 0, end = array.length - 1;
		while (start < end) {
			int a = Math.abs(array[start]);
			int b = Math.abs(array[end]);
			if (a > b) {
				result++;
				start++;
			} else if (a < b) {
				result++;
				end--;
			} else {
				end--;
			}
		}
		result++;
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] { -5, -3, 0, 1, 3 };
		int[] input1 = new int[] { -5, -5, 5, 5, 5, 5, 5 };
		int[] input2 = new int[] { -9, -5, -4, 0, 5, 15, 25 };

		System.out.println(countDistinct(input));
		System.out.println(countDistinct(input1));
		System.out.println(countDistinct(input2));
	}

}
