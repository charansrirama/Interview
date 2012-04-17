package th.leetcode;

public class PermutationSequence {
	
	public static String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		StringBuilder sb = new StringBuilder();
		int list[] = new int[n];
		for(int i = 1; i <=n; i++) {
			list[i-1] = i;
		}
		if(k == 1) {
			for(int i = 0; i < n; i++) {
				sb.append(list[i]);
			}
			return sb.toString();
		}
		int counter = 2;
		while(getNextPermutation(list)){
			if(counter == k) {
				for(int i = 0; i < n; i++) {
					sb.append(list[i]);
				}
				return sb.toString();
			} else {
				counter++;
			}
		}
		return "";
    }
	
	public static boolean getNextPermutation(int[] list) {
		for(int i = list.length-2; i >= 0; i--) {
			if(list[i] < list[i+1]) {
				for(int j = list.length-1; j > i; j--) {
					if(list[j] > list[i]) {
						swap(list, i, j);
						int start = i+1;
						int end = list.length-1;
						while(end>=start){
							swap(list, start, end);
							start++;
							end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
