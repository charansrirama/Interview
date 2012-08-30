package th.c.Leetcode;

import java.util.*;

public class ContainerWithMostWater {

	public static int largestRetangle(int[] height) {
        int maxArea = 0;
        Stack<Integer> heights = new Stack<Integer>();
        Stack<Integer> indeces = new Stack<Integer>();
        
        for(int i = 0; i < height.length; i++) {
        	if(heights.isEmpty() || height[i] > heights.peek()) {
        		heights.push(height[i]);
        		indeces.push(i);
        	} else if(height[i] < heights.peek()){
        		int lastIndex = 0;
        		while(!heights.isEmpty() && height[i] < heights.peek()) {
        			lastIndex = indeces.pop();
        			int tmp = heights.pop()*(i-lastIndex-1);
        			if(tmp > maxArea) maxArea = tmp;
        		}
        		heights.push(height[i]);
        		indeces.push(lastIndex);
        	}
        }
        
        while(!heights.isEmpty()) {
        	int tmp = heights.pop()*(height.length - indeces.pop()-1);
        	if(tmp > maxArea) maxArea = tmp;
        }
        return maxArea;
    }
	
	public static int maxArea(int[] height) {
		if(height.length == 0 || height == null) return -1;
		int maxArea = 0;
		int i = 0, j = height.length-1;
		while(i < j) {
			int min = height[i] < height[j] ? height[i] : height[j];
			int area = min*(j-i);
			if(area > maxArea) maxArea = area;
			if(height[i] <= height[j]) {
				i++;
				while(height[i] < min && i < j) i++;
			} else {
				j--;
				while(height[j] < min && i < j) j--;
			}
		}
		return maxArea;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = new int[]{2,1,4,5,1,3,3};
//		System.out.println(largestRetangle(array));
		
		int[] array1 = new int[]{1,2,1};
		System.out.println(maxArea(array1));
	}

}
