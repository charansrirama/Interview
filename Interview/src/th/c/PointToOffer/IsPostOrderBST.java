package th.c.PointToOffer;

public class IsPostOrderBST {

	public static boolean isBST(int[] A, int start, int end) {
		if(A == null || end-start <= 0) return true;
		int root = A[end];
		int i = start;
		for(; i <= end; i++) {
			if(A[i] > root) 
				break;
		}
		int j = i;
		for(; j <= end; j++) {
			if(A[j] < root)
				return false;
		}
		
		boolean left = true;
		if(i > 0) 
			left = isBST(A,start, i-1);
		boolean right = true;
		if(i < end) 
			right = isBST(A, i, end-1);
		
		return left && right;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {
			5,7,6,9,11,10,8	
		};
		int[] B = {
				7,4,6,5
		};
		System.out.println(isBST(A, 0, A.length-1));
		System.out.println(isBST(B, 0, B.length-1));
	}

}
