package amazon;

public class EditDistance {

	// AC
	public int minDistance(String word1, String word2) {
		int len1 = word1.length()+1;
		int len2 = word2.length()+1;
		
		int[][] matrix = new int[len1][len2];
		matrix[0][0] = 0;
		for(int i = 1; i < len1; i++) 
			matrix[i][0] = matrix[i-1][0]+1;
		for(int i = 1; i < len2; i++) 
			matrix[0][i] = matrix[0][i-1]+1;
		for(int i = 1; i < len1; i++) {
			for(int j = 1; j < len2; j++) {
				int diagonal = matrix[i-1][j-1];
				if(word1.charAt(i-1) != word2.charAt(j-1))
					diagonal+=1;
				matrix[i][j] = Math.min(diagonal, Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1));
			}
		}
		return matrix[len1-1][len2-1];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
