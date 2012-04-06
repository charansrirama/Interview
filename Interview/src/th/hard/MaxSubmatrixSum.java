package th.hard;

public abstract class MaxSubmatrixSum {
	
	// O(n4)
	public int[][] precomputing(int[][] matrix) {
		int[][] sum = new int[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(i == 0 && j == 0) sum[i][j] = matrix[i][j];
				else if(i == 0) {
					sum[i][j] = sum[i][j-1] + matrix[i][j];
				} else if(j == 0) {
					sum[i][j] = sum[i-1][j] + matrix[i][j];
				} else {
					sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
				}
			}
		}
		return sum;
	}
	
	public int computeSum(int[][] matrix, int i1, int i2, int j1, int j2) {
		if(i1 == 0 && j1 == 0) {
			return matrix[i2][j2];
		} else if(i1 == 0) {
			return matrix[i2][j2] - matrix[i2][j1-1];
		} else if(j1 == 0) {
			return matrix[i2][j2] - matrix[i1-1][j2];
		} else {
			return matrix[i2][j2] - matrix[i2][j1-1] -matrix[i1-1][j2] + matrix[i1-1][j1-1];
		}
	}
	
	public int getMaxSubMatrix(int[][] original) {
		int maxArea = Integer.MIN_VALUE;
		int rowCount = original.length;
		int columnCount = original.length;
		int[][] sumMatrix = precomputing(original);
		
		for(int row1 = 0; row1 < rowCount; row1++) {
			for(int row2 = row1; row2 < rowCount; row2++) {
				for(int col1 = 0; col1 < columnCount; col1++) {
					for(int col2 = col1; col2 < columnCount; col2++) {
						maxArea = Math.max(maxArea, computeSum(sumMatrix, row1, row2, col1, col2));
					}
				}
			}
		}
		return maxArea;
	}
	
	// O(n3) version
	
	public void clearArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}
	
	public int maxSubArray(int array[], int N) {
		int maxSum = 0;
		int runningSum = 0;
		
		for(int i = 0; i < N; i++) {
			runningSum += array[i];
			maxSum = Math.max(runningSum, maxSum);
			
			if(runningSum < 0) runningSum = 0;
		}
		return maxSum;
	}
	
	public int maxSubMatrix(int[][] original) {
		int rowCount = original.length;
		int colCount = original.length;
		
		int[] partialSum = new int[colCount];
		int maxSum = 0;
		for(int rowStart = 0; rowStart < rowCount; rowStart++) {
			clearArray(partialSum);
			for(int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
				for(int i = 0; i < colCount; i++) {
					partialSum[i] += original[rowEnd][i];
				}
				int tempMaxSum = maxSubArray(partialSum, colCount);
				maxSum = Math.max(tempMaxSum, maxSum);
			}
		}
		return maxSum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
