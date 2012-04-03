package th.hard;

public class PartialUnsorted {

	public int findEndOfLeftSequence(int[] a) {
		for(int i = 1; i < a.length; i++) {
			if(a[i] < a[i-1]) return i-1;
		}
		return a.length-1;
	}
	
	public int findStartOfRightSequence(int[] a) {
		for(int i = a.length-2; i >= 0; i--) {
			if(a[i] > a[i+1]) return i+1;
		}
		return 0;
	}
	
	public int shrinkLeft(int[] a, int min_index, int start) {
		int comp = a[min_index];
		for(int i = start-2; i >= 0; i--) {
			if(a[i] <= comp) return i+1;
		}
		return 0;
	}
	
	public int shrinkRight(int[] a, int max_index, int end) {
		int comp = a[max_index];
		for(int i = end + 2; i < a.length; i++) {
			if(a[i] >= comp) return i-1;
		}
		return a.length-1;
	}
	
	public void findUnsortedSequence(int[] a) {
		int end_left = findEndOfLeftSequence(a);
		int start_right = findStartOfRightSequence(a);
		
		int min_index = end_left+1;
		int max_index = start_right-1;
		
		for(int i = min_index; i <= max_index; i++) {
			if(a[i] < a[min_index]) min_index = i;
			if(a[i] > a[max_index]) max_index = i;
		}
		
		int left_index = shrinkLeft(a, min_index, end_left);
		int right_index = shrinkRight(a, max_index, start_right);
		
		System.out.println(left_index + " " + right_index);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		PartialUnsorted test = new PartialUnsorted();
		test.findUnsortedSequence(a);
	}

}
