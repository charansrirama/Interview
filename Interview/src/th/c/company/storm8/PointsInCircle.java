package th.c.company.storm8;

public class PointsInCircle {

	public static int findPoints(int r) {
		int n = 0;
		for(int a = 2; a < r; a++) 
			for(int b = 1; b < a; b++) 
				n++;
		n = n*8 + (int)(r/Math.sqrt(2))*4 + r*4+1;
		return n;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPoints(2));
	}

}
