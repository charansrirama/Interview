package th.c.Leetcode;

import java.util.*;

public class ContainerWithMostWater {
	
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
