package th.pocket.gems;

public class LargestPalidrome {
	
	public static boolean isPalidrome(int n) {
		int high = 1;
		while(n/high > 10) {
			high *= 10;
		}
		
		while(n != 0) {
			int l = n/high;
			int r = n%10;
			if(l != r) return false;
			n = (n%high)/10;
			high /= 100;
		}
		return true;
	}
	// brute force way
	public static int findLargestPalidrome() {
		int max = 0;
		for(int i = 999; i >= 100; i--) {
			for(int j = 999; j >= 100; j--) {
				if(max >= i*j) break;
				if(isPalidrome(i*j)) 
					max = i*j;
			}
		}
		return max;
	}
	
	public static void main(String[] main) {
		System.out.println(findLargestPalidrome());
	}
}
