package th.leetcode;

public class UniquePathOne {
	
	public static int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// 0 for down move, 1 for right move
		int[] move = new int[n+m-2];
		for(int i = 0; i < m-1; i++) {
			move[i] = 0;
		}
		
		for(int i = 0; i < n-1; i++) {
			move[m-1+i] = 1;
		}
		th.util.Printer.arrayPrinter(move);
		int count = 1;
		while(getNextPerm(move)){
			count++;
		}
		return count;
    }
	
	public static boolean getNextPerm(int[] move) {
		for(int i = move.length-2; i >= 0; i--) {
			if(move[i] < move[i+1]){
				for(int j = move.length-1; j > i; j--) {
					if(move[j] > move[i]) {
						swap(move, i, j);
						int start = i+1;
						int end = move.length-1;
						while(end >= start) {
							swap(move, start, end);
							start++; end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void swap(int[] move, int i, int j) {
		int temp = move[i];
		move[i] = move[j];
		move[j] = temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(uniquePaths(2,2));
	}

}
