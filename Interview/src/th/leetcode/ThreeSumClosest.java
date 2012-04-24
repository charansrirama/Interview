package th.leetcode;

import java.util.*;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int len = num.length;

		int closest = Integer.MAX_VALUE;

		for (int i = 0; i < len - 2; i++) {
			int start = i + 1;
			int end = len - 1;
			int sum = num[i] + num[start] + num[end];
			int runningClosest = sum;

			if (sum < target) {
				start++;
			} else if (sum > target) {
				end--;
			} else {
				return target;
			}

			while (start < end) {
				int subsum = num[i] + num[start] + num[end];
				runningClosest = Math.abs(subsum - target) > Math
						.abs(runningClosest - target) ? runningClosest : subsum;
				if (subsum < target) {
					start++;
				} else if (subsum > target) {
					end--;
				} else {
					return target;
				}
			}
			if (i == 0)
				closest = runningClosest;
			else
				closest = Math.abs(target - runningClosest) < Math.abs(target
						- closest) ? runningClosest : closest;
		}
		return closest;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = new int[] { -1, 2, 1, -4 };
		System.out.println(threeSumClosest(num, 1));
	}

}
