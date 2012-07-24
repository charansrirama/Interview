package th.c.cracking;

public class MaxSequenceSum {
	public int maxSequenceSum(int[] array) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum+=array[i];
			if(maxSum < sum) 
				maxSum = sum;
			else if(sum < 0) 
				sum = 0;
		}
		return maxSum;
	}
}
