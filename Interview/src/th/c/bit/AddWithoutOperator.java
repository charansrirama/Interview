package th.c.bit;

public class AddWithoutOperator {

	public static int add(int a, int b) {
		if(b == 0) return a;
		int sumWithoutCarry = a^b;
		int carry = (a&b) << 1;
		return add(sumWithoutCarry, carry);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(-11, 10));
	}

}
