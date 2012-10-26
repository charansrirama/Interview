package th.c.DivideAndConquer;

public class MaxMin {

	public Pair maxMin(int[] A) {
		return getMaxMin(A, 0, A.length-1);
	}
	
	private Pair getMaxMin(int[] A, int left, int right) {
		if(left == right) {
			Pair p = new Pair(A[left], A[right]);
			return p;
		} else if(right - left == 1) {
			Pair p = new Pair();
			p.max = A[right] > A[left] ? A[right] : A[left];
			p.min = A[right] > A[left] ? A[left] : A[right];
			return p;
		} else {
			int mid = (left+right)/2;
			Pair p1 = getMaxMin(A, left, mid);
			Pair p2 = getMaxMin(A, mid+1, right);
			Pair p = new Pair();
			p.max = p1.max > p2.max ? p1.max : p2.max;
			p.min = p1.min < p2.min ? p1.min : p2.min;
			return p;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1000, 11, 445, 1, 330, 3000};
		MaxMin test = new MaxMin();
		Pair re = test.maxMin(A);
		System.out.println(re.max + " " + re.min);
	}

}

class Pair {
	int max;
	int min;
	
	public Pair(int max, int min) {
		this.max = max;
		this.min = min;
	}
	
	public Pair() {
	}
}