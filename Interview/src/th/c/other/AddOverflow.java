package th.c.other;

public class AddOverflow {

	// Three condition
	// 1. a >0 && b > 0 2. a < 0 && b < 0 3. a < 0 && b > 0 || a > 0 && b < 0
	public static boolean overflow(int a, int b) {
		if (a > 0 && b > 0) {
			if (Integer.MAX_VALUE - a < b)
				return true;
			else
				return false;
		} else if(a < 0 && b < 0) {
			if(Integer.MIN_VALUE - a > b) 
				return true;
			else 
				return false;
		} else {
			if(a < 0) {
				if(a > Integer.MIN_VALUE && b < Integer.MAX_VALUE)
					return false;
				else 
					return true;
			} else {
				if(a < Integer.MAX_VALUE && a > Integer.MIN_VALUE) 
					return false;
				else 
					return true;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(overflow(4, 5));
		System.out.println(overflow(1111111111, 1036372538));
		System.out.println(overflow(-1111111111, 1036372538));
		System.out.println(overflow(-1111111111, 0));
		System.out.println(overflow(0, 1036372538));
	}

}
