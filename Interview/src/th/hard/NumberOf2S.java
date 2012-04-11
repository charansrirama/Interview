package th.hard;

public class NumberOf2S {

	// Brute force method Time O(n)
	
	public static int numberOf2S(int n) {
		int count = 0;
		while(n > 0) {
			if(n%10 == 2) {
				count++;
			}
			n = n/10;
		}
		return count;
	}
	
	public static int countNumberOf2S(int n) {
		int count = 0; 
		for(int i = 0; i <=n; i++) {
			count += numberOf2S(i);
		}
		return count;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countNumberOf2S(22));
	}

}
