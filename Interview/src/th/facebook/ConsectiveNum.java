package th.facebook;

public class ConsectiveNum {

	public static int[] consecutiveNum(int[] A) {
		int[] result = new int[2];
		int max = 0, running = 0;
		int s = 0, e = 0, rs = 0, re = 0;
		for(int i = 0; i < A.length; i++) {
			running += A[i];
			re = i;
			if(running > max) {
				max = running;
				e = re;
				s = rs;
			}
			if(running < 0) {
				running = 0;
				if(i != A.length-1) {
					re = i+1;
					rs = i+1;
				}
			}
		}
		result[0] = s;
		result[1] = e;
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
