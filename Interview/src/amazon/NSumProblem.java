package amazon;

import java.util.*;

public class NSumProblem {

	// AC
	public int[] twoSum(int[] numbers, int target) {
		int result[] = new int[2];
		for(int i = 0; i < numbers.length; i++) {
			int tmp = target - numbers[i];
			for(int j = i+1; j < numbers.length; j++) {
				if(tmp == numbers[j]) {
					result[0] = i+1;
					result[1] = j+1;
				}
			}
		}
		return result;
    }
	
	// AC
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		
		for(int i = 0; i < num.length-2; i++) {
			int left = 0 - num[i];
			int head = i+1;
			int tail = num.length-1;
			while(head < tail) {
				int tmp = num[head] + num[tail];
				if(tmp > left) {
					tail--;
				} else if(tmp < left) {
					head++;
				} else {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[head]);
					list.add(num[tail]);
					result.add(list);
					while(head+1 < tail && num[head] == num[head+1]) {
						head++;
					}
					head++;
				}
			}
			while(i+1 < num.length && num[i] == num[i+1]) {
				i++;
			}
		}
		return result;
    }
	
	// AC
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(num.length < 4) 
			return results;
		
		Arrays.sort(num);
		for(int i = 0; i < num.length - 3; i++) {
			for(int j = i+1; j < num.length - 2; j++) {
				int start = j + 1;
				int end = num.length - 1;
				int left = target - num[i] - num[j];
				while(start < end) {
					int s = num[start] + num[end];
					if(s > left) {
						end--;
					} else if(s < left) {
						start++;
					} else {
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(num[i]);
						result.add(num[j]);
						result.add(num[start]);
						result.add(num[end]);
						results.add(result);
						while(start+1 < end && num[start] == num[start+1]) {
							start++;
						}
						start++;
					}
				}
				while(j+1 < num.length && num[j] == num[j+1]) {
					j++;
				}
			}
			while(i+1 < num.length && num[i] == num[i+1]){
				i++;
			}
		}
		return results;
	}
	
	
	// AC
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
        int closest = Integer.MAX_VALUE;
        int len = num.length;
        for(int i = 0; i < len-2; i++) {
        	int start = i+1;
        	int end = len-1;
        	int sum = num[i] + num[start] + num[end];
        	int runningClosest = sum;
        	
        	if(sum < target) {
        		start++;
        	} else if(sum > target) {
        		end--;
        	} else {
        		return target;
        	}
        	while(start < end) {
        		int subsum = num[i] + num[start] + num[end];
        		runningClosest = Math.abs(subsum-target) > Math.abs(runningClosest-target)?runningClosest:subsum;
        		if(subsum < target){
        			start++;
        		} else if(subsum > target) {
        			end--;
        		} else {
        			return target;
        		}
        	}
        	if(i == 0) 
        		closest = runningClosest;
        	else 
        		closest = Math.abs(target-runningClosest) < Math.abs(target-closest) ? runningClosest:closest;
        }
        return closest;
    }
	
	// AC too but has magic number problem;
	// int 类型的边界bug问题。这个得注意。
	// math.abs 会将超过边界值的变成负数。 如果将long closest改成int就能看到bug。
	public static int threeSumClosest2(int[] num, int target) {
		Arrays.sort(num);
		long closest = Integer.MAX_VALUE;
		for(int i = 0; i < num.length-2; i++) {
			int start = i+1;
			int end = num.length-1;
			while(start < end) {
				int sum = num[i] + num[start] + num[end];
				if(sum < target) {
	        		start++;
	        	} else if(sum > target) {
	        		end--;
	        	} else {
	        		return target;
	        	}
				closest = Math.abs(sum-target) > Math.abs(closest-target)? closest : sum;
			}
		}
		return (int)closest;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = new int[]{-3,-2,-5,3,-4};
		threeSumClosest2(num, -1);
	}

}
