package th.c.PointToOffer;

import java.util.*;

public class IsPopOrder {

	public static boolean isPopOrder(int[] A, int[] B) {
		if(A.length != B.length) return false;
		if(A.length == 0 && B.length == 0) return true;
		Stack<Integer> stack = new Stack<Integer>();
		int p = 0;
		int q = 0;
		while(p != B.length) {
			while(stack.isEmpty() || stack.peek() != B[p]) {
				if(q == A.length) break;
				stack.push(A[q++]);
			}
			if(stack.peek() != B[p]) 
				break;
			stack.pop();
			p++;
		}
		return stack.isEmpty() && p == B.length;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B = {3,2,1,4,5};
		int[] C = {5,4,3,2,1};
		int[] D = {4,3,5,1,2};
		int[] E = {6,3,2,1,5};
		
		System.out.println(isPopOrder(A, B));
		System.out.println(isPopOrder(A, C));
		System.out.println(isPopOrder(A, D));
		System.out.println(isPopOrder(A, E));
	}

}
