package th.facebook;

public class NQueens {

	public void nQueens(int n) {
		int[] columnIndex = new int[n];
		for(int i = 0; i < n; i++) {
			columnIndex[i] = i;
		}
		nQueens(columnIndex, 0, columnIndex.length-1);
	}
	
	public void printQueenLocation(int[] columnIndex) {
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
	
	private void nQueens(int[] columnIndex, int start, int end) {
		if(start > end) {
			printQueenLocation(columnIndex);
		} else {
			for(int i = start; i <= end; i++){
				swap(columnIndex, start, i);
				nQueens(columnIndex, start+1, end);
				swap(columnIndex, start, i);
			}
		}
	}
	
	private void swap(int[] columnIndex, int i, int j) {
		int tmp = columnIndex[i];
		columnIndex[i] = columnIndex[j];
		columnIndex[j] = tmp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NQueens n = new NQueens();
		n.nQueens(8);
	}

}
