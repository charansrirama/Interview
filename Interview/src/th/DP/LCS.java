package th.DP;

/**
 * shijinliang
 * Mar 11, 2012
 * Interview
 **/
public class LCS {
    
    public static String findLCS(String x, String y) {
	String result = "";
	
	int matrix[][] = new int[x.length()+1][y.length()+1];
	String path[][] = new String[x.length()+1][y.length()+1];
	
	for(int i = 1; i < matrix.length; i++) {
	    for(int j = 1; j < matrix[i].length; j++) {
		if(x.charAt(i-1) == y.charAt(j-1)) {
		    matrix[i][j] = matrix[i-1][j-1]+1;
		    path[i][j] = "(i-1,j-1)";
		} else if(matrix[i-1][j] >= matrix[i][j-1]) {
		    matrix[i][j] = matrix[i-1][j];
		    path[i][j] = "(i-1,j)";
		} else {
		    matrix[i][j] = matrix[i][j-1];
		    path[i][j] = "(i,j-1)";
		}
	    }
	}
	printMatrix(matrix);
	printMatrix(path);
	printPath(path, x, path.length-1, path[0].length-1);
	return result;
    }
    
    public static void printMatrix(int matrix[][]) {
	for(int i = 0; i < matrix.length; i++) {
	    for(int j = 0; j < matrix[i].length; j++) {
		System.out.print(matrix[i][j] + "\t");
	    }
	    System.out.println();
	}
    }

    public static void printMatrix(String path[][]) {
	for(int i = 0; i < path.length; i++) {
	    for(int j = 0; j < path[i].length; j++) {
		System.out.print(path[i][j] + "\t");
	    }
	    System.out.println();
	}
    }
    
    public static void printPath(String path[][], String x, int i, int j) {
	if(i == 0 || j == 0) 
	    return;
	if(path[i][j] == "(i-1,j-1)") {
	    printPath(path, x, i-1, j-1);
	    System.out.print(x.charAt(i-1));
	} else if(path[i][j] == "(i-1,j)") {
	    printPath(path, x, i-1, j);
	} else {
	    printPath(path, x, i, j-1);
	}
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	String x = "ABCBDAB";
	String y = "BDCABA";
	
	findLCS(x, y);
    }

}
