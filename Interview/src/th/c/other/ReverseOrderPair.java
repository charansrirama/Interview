package th.c.other;

public class ReverseOrderPair {
	
	//O(n2)
	public static int findReverseOrderPair(int[] input) {
		if(input == null) return 0;
		int count = 0;
		for(int i = 0; i < input.length; i++) {
			for(int j = i+1; j < input.length; j++) {
				if(input[i] > input[j]) 
					count++;
			}
		}
		return count;
	}
	
	public static int findReverseOrderPair2(int[] input, int left, int right) {
		if(right < left) return 0;
		int mid = (left+right)/2;
		int reverseCount = 0;
		if(mid > left) reverseCount += findReverseOrderPair2(input, left, mid);
		if(mid+1 < right) reverseCount += findReverseOrderPair2(input, mid+1, right);
		
		int l1 = left, l2 = mid+1, l3 = 0;
		int[] tmp = new int[right-left+1];
		while(l1 <= mid && l2 <= right) {
			if(input[l1] > input[l2]) {
				for(int i = l1; i <= mid; i++) {
					reverseCount++;
					System.out.println(input[i] + "," + input[l2]);
					}
				tmp[l3++] = input[l2++];
			} else {
				tmp[l3++] = input[l1++];
			}
		}
		if(l1 <= mid) {
			for(int i = l1; i <= mid; i++) tmp[l3++] = input[i];
		} else if(l2 <= right) {
			for(int i = l2; i <= right; i++) tmp[l3++] = input[i];
		}
		for(int i = 0, j = left+i; i < l3; i++, j++) {
			input[j] = tmp[i];
		}
		return reverseCount;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{3,0,4,5,1,2};
		System.out.println(findReverseOrderPair(input));
		System.out.println(findReverseOrderPair2(input,0,5));
	}

}
