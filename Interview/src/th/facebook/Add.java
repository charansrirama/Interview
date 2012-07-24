package th.facebook;

public class Add {

	public static int add(int a, int b) {
		if(b == 0) return a;
		int sum = a^b;
		int carry = (a&b)<<1;
		return add(sum, carry);
	}
	// subtraction is another version of add
	// 5-7 = 5 + (-7)
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(6, 4));
	}

}
