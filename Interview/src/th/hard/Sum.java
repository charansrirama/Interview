package th.hard;

public class Sum {

	public static int add(int a, int b) {
		if(b == 0) return a;
		int sum = a^b;
		int carry = (a&b) << 1;
		return add(sum, carry);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(add(111, 299));	
	}

}
