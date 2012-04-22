package th.facebook;
// Subset problem class
public class SubSet {

	public static String[] subSetBinary(char[] array) {
		int p = power(array.length);
		String[] result = new String[p];
		
		for(int i = 0; i < p; i++) {
			String binary = "";
			int temp = i;
			for(int j = 0; j < array.length; j++) {
				int re = temp%2;
				temp = temp/2;
				binary = re + binary;
			}
			result[i] = binary2String(binary, array);
		}
		return result;
	}
	
	public static int power(int n) {
		int result = 1;
		while(n!=0){
			result *= 2;
			n--;
		}
		return result;
	}
	
	public static String binary2String(String binary, char[] array) {
		String result = "";
		for(int i = 0; i < binary.length(); i++) {
			if(binary.charAt(i) == '1') {
				result = result + array[i];
			}
		}
		if(result == ""){
			result = "Empty set";
		}
		return result;
	}
	
	// Recursion version
	public static String[] subSetRecursion(char[] array) {
		int p = power(array.length);
		String[] result = new String[p];
		
		if(array.length == 1) {
			result[0] = "Empty set";
			result[1] = array[0]+"";
		} else {
			int sp = power(array.length-1);
			String[] sresult = new String[sp];
			char[] sa = new char[array.length-1];
			for(int i = 0; i < array.length-1; i++) {
				sa[i] = array[i];
			}
			sresult = subSetRecursion(sa);
			char left = array[array.length-1];
			for(int i = 0; i < sresult.length; i++) {
				result[i] = sresult[i];
			}
			for(int i = sresult.length; i < result.length; i++) {
				if(sresult[i-sresult.length] == "Empty set"){
					result[i] = left+"";
				} else {
					result[i] = sresult[i-sresult.length] + left;
				}
				
			}
		}
		
		return result;
	}
	
	// Subset sum problem DP solution
	// Similar solution for dropbox challenge 
	public static boolean subsetSum(int[] array, int sum) {
		boolean[][] matrix = new boolean[array.length+1][sum+1];
		for(int i = 0; i <= array.length; i++) {
			matrix[i][0] = true;
		}
		for(int i = 0; i <= sum; i++) {
			matrix[0][i] = false;
		}
		matrix[0][0] = true;
		for(int i = 1; i <= array.length; i++) {
			for(int j = 1; j <= sum; j++) {
				matrix[i][j] = matrix[i-1][j] || (array[i-1]<=j && matrix[i-1][j-array[i-1]]);
			}
		}
		
		for(int i = 0; i <= array.length; i++) {
			for(int j = 0; j <= sum; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		for(int i = array.length; i >= 0; i--) {
			int j = sum;
			if(matrix[i][j]) {
				System.out.print(array[i-1] + " ");
				j -= array[i-1];
			} else 
				continue;
			int r = i;
			while(j > 0 && r >= 1) {
				if(matrix[r][j] && !matrix[r-1][j]){
					System.out.print(array[r-1] + " ");
					j -= array[r-1];
				} else {
					r--;
				}
			}
			System.out.println();
		}
		return matrix[array.length][sum];
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String[] r = subSetBinary(new char[]{'a','b','c'});
//		String[] r = subSetRecursion(new char[]{'a','b','c'});
//		for(String s : r) {
//			System.out.println(s);
//		}
		
		int[] a = new int[]{1,2,3,4,5,6,7};
		System.out.println(subsetSum(a, 9));
	}
}
