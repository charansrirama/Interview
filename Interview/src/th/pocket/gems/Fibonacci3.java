package th.pocket.gems;

public class Fibonacci3 {

	public static int[] generateFibonacci3(int len) {
		int[] fibonacci = new int[len];
		for(int i = 0; i < fibonacci.length; i++) {
			fibonacci[i] = 1;
		}
		if(fibonacci.length <= 3) {
			return fibonacci;
		}
		for(int i = 3; i < len; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2] + fibonacci[i-3];
		}
		
		return fibonacci;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fib = generateFibonacci3(10);
		th.util.Printer.arrayPrinter(fib);
	}

}
