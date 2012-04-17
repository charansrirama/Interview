package th.leetcode;

public class SpiralMatrix2 {
	
	public static int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0) return new int[][]{};
        
        int result[][] = new int[n][n];
        int count = 1;
        int A = 0, B = n-1;
        int C = 0, D = n-1;
        
        while(count <= n*n) {
        	for(int i = A; i <= B; i++){
        		result[C][i] = count++;
        	}
        	C++;
        	if(C > D) break;
        	for(int i = C; i <= D; i++) {
        		result[i][B] = count++;
        	}
        	B--;
        	if(B < A) break;
        	for(int i = B; i >= A; i--) {
        		result[D][i] = count++;
        	}
        	D--;
        	if(D < C) break;
        	for(int i = D; i >= C; i--) {
        		result[i][A] = count++;
        	}
        	A++;
        }
        
        return result; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] result = generateMatrix(4);
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++)
				System.out.print(result[i][j] + " ");
		}
	}

}
