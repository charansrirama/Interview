package th.DP;

public class Fibonacci {
	
	public static int fibonacci(int num) {
		if(num <= 0) return -1;
		if(num <= 2) return 1;
		int[] fib = new int[num+1];
		fib[1] = fib[2] = 1;
		for(int i = 3; i <= num; i++) 
			fib[i] = fib[i-1]+fib[i-2];
		return fib[num];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 10; i++)
			System.out.print(fibonacci(i)+ " ");
	}

}
