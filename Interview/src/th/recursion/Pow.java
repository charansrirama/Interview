package th.recursion;

public class Pow {

	public static int pow(int base, int power) {
		if(0 == power) return 1;
		if(1 == power) return base;
		
		if(0 == power%2) 
			return pow(base, power/2)*pow(base, power/2);
		else
			return pow(base, power/2)*pow(base, power/2)*base;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(pow(2, 3));
		System.out.println(pow(2, 4));
		System.out.println(pow(3, 3));
	}

}
