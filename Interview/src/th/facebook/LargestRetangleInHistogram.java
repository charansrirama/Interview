package th.facebook;

import java.util.*;

public class LargestRetangleInHistogram {

	//O(n^2) solution
	public static long largestRetangle1(int[] a) {
		long result = 0;
		for (int i = 0; i < a.length; i++) {
			int height = a[i];
			int width = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] == 0) {
					break;
				} else if (height > a[j]) {
					height = a[j];
				}
				width++;
				int tmp = height*width;
				if(tmp>result) result = tmp;
			}
		}
		return result;
	}
	
	public static long largestRetangle(int[] a) {
		long maxArea = 0;
		
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexes = new Stack<Integer>();
		
		for(int i = 0; i < a.length; i++) {
			if(heights.isEmpty() || heights.peek() < a[i]) {
				heights.push(a[i]);
				indexes.push(i);
			} else if(heights.peek() > a[i]) {
				int lastIndex = 0;
				while(!heights.isEmpty() && a[i] < heights.peek()) {
					lastIndex = indexes.pop();
					long tmp = heights.pop()*(i-lastIndex);
					if(maxArea < tmp) maxArea = tmp;
				}
				heights.push(a[i]);
				indexes.push(lastIndex);
			}
		}
		while(!heights.isEmpty()) {
			int tmp = heights.pop()*(a.length-indexes.pop());
			if(maxArea < tmp) 
				maxArea = tmp;
		}
		return maxArea;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{2,1,4,5,1,3,3};
		System.out.println(largestRetangle1(array));
		System.out.println(largestRetangle(array));
	}

}

class Item {
	int value;
	int pos;
	
	public Item(int val, int pos) {
		this.value = val;
		this.pos = pos;
	}
}