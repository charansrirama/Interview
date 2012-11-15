package th.c.PointToOffer;

public class Count1InBinary {

	public static int count1(int A) {
		int mask = 1;
		int count = 0;
		while(mask <= A) {
			if((mask&A) != 0) 
				count++;
			mask<<=1;
		}
		return count;
	}
	
	public static int count12(int A) {
		int count = 0;
		while(A != 0) {
			count++;
			A = A&(A-1);
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count1(2));
	}

}
