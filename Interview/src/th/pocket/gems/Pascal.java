package th.pocket.gems;

public class Pascal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 10;
		int[][] pascal = new int[N][N];
		for(int i = 0; i < N; i++) {
			pascal[i][0] = 1;
		}
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < N; j++) {
				pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= N-i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j <= i; j ++) {
				System.out.print(pascal[i][j] + " ");
			}
			System.out.println();
		}
	}

}
