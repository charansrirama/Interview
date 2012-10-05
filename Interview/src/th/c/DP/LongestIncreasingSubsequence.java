package th.c.DP;

public class LongestIncreasingSubsequence {

	public static int lis1(int[] num, int len) {
		int list[] = new int[len];
		for(int i = 0; i < len; i++) {
			list[i] = 1;
			for(int j = 0; j < i; j++) {
				if(num[i] > num[j] && list[j] + 1 > list[i]) {
					list[i] = list[j] + 1;
				}
			}
		}
		int max = 0;
		for(int i : list) {
			if(i > max) max = i;
		}
		return max;
	}
	// n*lg(n)
	public static int lis(int[] num, int n) {
		int b[] = new int[n];
		int left, right, mid, len = 1;
		b[0] = num[0];
		for(int i = 1; i < n; i++) {
			left = 0;
			right = len;
			while(left <= right) {
				mid = (left+right)/2;
				if(b[mid] < num[i]) left = mid+1;
				else right = mid-1;
			}
			b[left] = num[i];
			if(left > len) len++;
		}
		return len;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4,6,5,7,3};
		System.out.println(lis(num, num.length));
	}

}
