package th.facebook;

import java.util.ArrayDeque;

public class SlidingWindowMax {
	
	/*
	 * 有一无序数组长度为n，以及一个可以从左到右移动的子数组，长度为k。
	 * 假设子数组起始位置为0，要求在子数组从最左到最右的移动过程中，输出子数组的最大值。
	 * 例如，有数组 2，3，4，2，6，7，8，2，4，1，2，3 
	 * k = 3
	 * 输出
	 * 4，4，6，7，8，8，8，4，4，4，3
	 */
	public static int[] slidingWindowMax(int[] array, int w) {
		int[] result = new int[array.length-w+1];
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		
		for(int i = 0; i < w; i++) {
			while(!q.isEmpty() && array[q.peekLast()] <= array[i]) 
				q.removeLast();
			q.addLast(i);
		}
		
		result[0] = array[q.peekFirst()];
		for(int i = w; i < array.length; i++) {
			while(!q.isEmpty() && array[q.peekLast()] <= array[i]) q.removeLast();
			while(!q.isEmpty() && q.peekFirst() <= i-w) q.pop();
			q.addLast(i);
			result[i-w+1] = array[q.peekFirst()];
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[]{2, 3, 4, 2, 6, 7, 8, 2,4,1,2,3};
		int[] b = slidingWindowMax(a, 3);
		for(int t : b) {
			System.out.print(t + " ");
		}
	}

}
