package amazon.leetcode;

import java.util.*;

public class LargestRetangleArea {

	public int largestRetangleArea(int[] height) {
		long maxArea = 0;
		
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexes = new Stack<Integer>();
		
		for(int i = 0; i < height.length; i++) {
			if(heights.isEmpty() || heights.peek() < height[i]){
				heights.push(height[i]);
				indexes.push(i);
			} else if(heights.peek() > height[i]) {
				int lastIndex = 0;
				while(!heights.isEmpty() && height[i] < heights.peek()) {
					lastIndex = indexes.pop();
					long tmp = heights.pop()*(i-lastIndex);
					if(maxArea < tmp) maxArea = tmp;
				}
				heights.push(height[i]);
				indexes.push(lastIndex);
			}
		}
		while(!heights.isEmpty()) {
			long tmp = heights.pop()*(height.length - indexes.pop());
			if(maxArea < tmp) {
				maxArea = tmp;
			}
		}
		return (int)maxArea;
	}
}
