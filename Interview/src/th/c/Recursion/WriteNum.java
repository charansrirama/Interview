package th.c.Recursion;

public class WriteNum {

	public static void writeNum(int n) {
		if(n == 0) return;
		writeNum(n-1);
		System.out.print(n + " ");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeNum(12);
	}

}
