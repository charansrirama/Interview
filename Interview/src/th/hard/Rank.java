package th.hard;

public class Rank {
	// Selection Rank algorithm
	
	public static int partition(int[] array, int left, int right, int pivot) {
		while(true) {
			while(left<=right && array[left] <= pivot) {
				left++;
			}
			while(left<=right && array[right] > pivot) {
				right--;
			}
			if(left > right) {
				return left-1;
			}
			swap(array, left, right);
		}
	}
	
	public static void swap(int[] array, int a, int b) {
		int temp;
		temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static int randomIntInRange(int lower, int higher) {
		return lower + (int)(Math.random()*(higher-lower+1));
	}
	
	public static int max(int[] array, int left, int right) {
		int max = Integer.MIN_VALUE;
		for(int i = left; i <= right; i++) {
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}
	
	public static int rank(int[] array, int left, int right, int rank) {
		int pivot = array[randomIntInRange(left, right)];
		
		int leftEnd = partition(array, left, right, pivot);
		
		int leftSize = leftEnd - left + 1;
		
		if(leftSize == rank+1) {
			return max(array, left, right);
		} else if(rank < leftSize) {
			return rank(array, left, leftEnd, rank);
		} else {
			return rank(array, leftEnd+1, right, rank-leftSize);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[]{11,33,44,55,9,3,2,4,66,1};
		System.out.println(rank(array, 0, array.length-1, 0));
		
	}

}
