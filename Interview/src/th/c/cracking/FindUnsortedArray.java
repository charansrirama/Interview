package th.c.cracking;

public class FindUnsortedArray {
	public int findEndOfLeftSubsequence(int[] array) {
		for(int i = 1; i < array.length; i++) {
			if(array[i] < array[i-1]) return i-1;
		}
		return array.length -1;
	}
	
	public int findStartOfRightSubsequence(int[] array) {
		for(int i = array.length-2; i>=0; i--) {
			if(array[i] > array[i+1]) return i+1;
		}
		return 0;
	}
	
	public int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for(int i = start-2; i>=0; i--) {
			if(array[i] <= comp) return i+1;
		}
		return 0;
	}
	
	public int shrinkRight(int[] array, int max_index, int end) {
		int comp = array[max_index];
		for(int i = end+2; i < array.length; i++) {
			if(array[i] >= comp) return i-1;
		}
		return array.length-1;
	}
	
	public void findUnsortedSequence(int[] array) {
		int leftEnd = findEndOfLeftSubsequence(array);
		int rightStart = findStartOfRightSubsequence(array);
		
		int min_index = leftEnd+1;
		int max_index = rightStart-1;
		for(int i = leftEnd; i <= rightStart; i++) {
			if(array[i] < array[min_index]) min_index = i;
			if(array[i] > array[max_index]) max_index = i;
		}
		
		int leftIndex = shrinkLeft(array, min_index, leftEnd);
		int rightIndex = shrinkRight(array, max_index, rightStart);
		
		System.out.println("[" + leftIndex + ", " + rightIndex + "]");
	}
}
