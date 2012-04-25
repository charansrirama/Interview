package th.leetcode;

public class EditDistance {

	public static int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
//        if(word1 == null) return word2.length();
//        if(word2 == null) return word1.length();
        
        int l1 = word1.length()+1;
        int l2 = word2.length()+1;
        
        int matrix[][] = new int[l1][l2];
        matrix[0][0] = 0;
        for(int i = 1; i < l1; i++) {
        	matrix[i][0] = i;
        }
        for(int i = 1; i < l2; i++) {
        	matrix[0][i] = i;
        }
        for(int i = 1; i < l1; i++) {
        	for(int j = 1; j < l2; j++) {
        		int diagonal = matrix[i-1][j-1];
        		if(word1.charAt(i-1) != word2.charAt(j-1)){
        			diagonal += 1; 
        		}
        		matrix[i][j] = Math.min(diagonal, Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1));
        	}
        }
		return matrix[l1-1][l2-1];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minDistance("", "vevvo"));
	}

}
