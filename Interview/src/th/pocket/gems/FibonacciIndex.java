package th.pocket.gems;

public class FibonacciIndex {

	public static int findIndex(int num) {
		if(num == 1) return 1;
		int index = 3;
		int fib1 = 1, fib2 = 2;
		while(num != fib2) {
			int tmp = fib2;
			fib2 = fib1+fib2;
			fib1 = tmp;
			index++;
		}
		return index;
	}
	
	public static void generateFibonacci(int[] fib) {
		fib[0] = 1;
		fib[1] = 1;
		for(int i = 2; i < fib.length; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fib = new int[100];
		generateFibonacci(fib);
		
		System.out.println(findIndex(fib[88]));
	}

}
