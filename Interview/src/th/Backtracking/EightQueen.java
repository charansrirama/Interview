package th.Backtracking;

public class EightQueen {
	
	private static int sum;
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean check(int[] columnIndex) {
		boolean re = true;
		for(int i = 0; i < columnIndex.length; i++) {
			for(int j = i+1; j < columnIndex.length; j++) {
				if((columnIndex[j] - columnIndex[i] == j-i) ||(columnIndex[j] - columnIndex[i] == i-j) ) {
					re = false;
					break;
				}
			}
		}
		return re;
	}
	
	public static void printQueenLocation(int[] columnIndex) {
		for(int i = 0; i < columnIndex.length; i++) {
//			System.out.println("(i, j) = (" + i + ", " + columnIndex[i] + ")");
			String line = "";
			for(int j = 0; j < columnIndex[i]; j++) {
				line = line+".";
			}
			line = line+"Q";
			for(int j = columnIndex[i]; j < columnIndex.length; j++) {
				line = line + ".";
			}
			System.out.println(line);
		}
		System.out.println("========");
	}
	
	public static void eightQueen(int[] columnIndex, int first, int last) {
		if(first == last ){
			if(check(columnIndex)){
				printQueenLocation(columnIndex);
				sum++;
			}
		} else {
			for(int i = first; i <= last; i++) {
				swap(columnIndex, first, i);
				eightQueen(columnIndex, first+1, last);
				swap(columnIndex, first, i);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int MAX = 8;
		int[] columnIndex = new int[MAX];
		for(int i = 0; i < MAX; i++) {
			columnIndex[i] = i;
		}
		eightQueen(columnIndex, 0, MAX-1);
		System.out.println(sum);
	}

}
