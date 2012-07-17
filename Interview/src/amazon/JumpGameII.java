package amazon;

public class JumpGameII {

	public int jump(int A[]) {
		int len = A.length;
		int steps[] = new int[len];
		steps[len-1] = 0;
		for(int i = len-2; i >= 0; i--) {
			int step = len;
			for(int j = 1; j <= A[i] && (i+j) < len; j++) {
				if(step > steps[i+j]) step = steps[i+j];
			}
			steps[i] = step+1;
		}
		return steps[0];
	}
}
