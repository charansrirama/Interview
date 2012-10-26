package th.c.DivideAndConquer;

public class FindKSmall {

	public int findKSmall(int[] A, int left, int right, int k) {
		int index = partition(A, left, right);
		if(index == k-1) {
			return A[index];
		} else if(index < k-1) {
			return findKSmall(A, index+1, right, k);
		} else {
			return findKSmall(A, left, index-1, k);
		}
	}
	
	public int partition(int[] A, int left, int right) {
		int m = right;
		int piviot = A[right];
		right--;
		while(true) {
			while(left <= right&&A[left] < piviot) left++;
			while(left <= right&&piviot < A[right]) right--;
			if(left >= right) break;
			int tmp = A[left];
			A[left] = A[right];
			A[right] = tmp;
			
		}
		A[m] = A[left];
		A[left] = piviot;
		return left;
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {2,3,1,6,4,5,11,33,10};
		FindKSmall test = new FindKSmall();
		System.out.println(test.findKSmall(input, 0, input.length-1, 2));
	}
}
