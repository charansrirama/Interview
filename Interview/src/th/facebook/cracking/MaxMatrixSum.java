package th.facebook.cracking;

public class MaxMatrixSum {
	public void clearArray(int[] array) {
		for(int i = 0; i < array.length; i++)
			array[i] = 0;
	}
	
	public int maxSubArray(int[] array) {
		int maxSum = 0;
		int running = 0;
		for(int i = 0; i < array.length; i++) {
			running += array[i];
			maxSum = Math.max(running, maxSum);
			if(running < 0) running = 0;
		}
		return maxSum;
	}
	
	public int maxSubMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		
		int[] partialSum = new int[colCount];
		int maxSum = 0;
		for(int rowStart = 0; rowStart < rowCount; rowStart++) {
			clearArray(partialSum);
			for(int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
				for(int i = 0; i < colCount; i++) {
					partialSum[i] += matrix[rowEnd][i];
				}
				
				int temp = maxSubArray(partialSum);
				maxSum = Math.max(temp, maxSum);
			}
		}
		return maxSum;
	}
}
