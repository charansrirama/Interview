package th.c.cracking;

public class FindFirstIndexInSortedArray {

	public static int getFirstIndex(int[] nums, int a, int start, int end) {
		if(end < start) return -1;
		if(nums[start] > a) return -1;
		if(nums[end] < a) return -1;
		
		if(nums[start] == a) return start;
		
		int mid = (start+end)/2;
		if(nums[mid] == a) {
			int leftIndex = getFirstIndex(nums, a, start, mid-1);
			return leftIndex == -1? mid:leftIndex;
		} else if(nums[mid] > a) 
			return getFirstIndex(nums, a, mid+1, end);
		else 
			return getFirstIndex(nums, a, start, mid-1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,3,3,3,3,3,3,3,3,4,5,6,7,8,9};
		System.out.println("First index of number 3 is "+getFirstIndex(nums, 3, 0, nums.length-1));
	}

}
