package th.c.Arrays;

public class NumAppearMoreThanHalf {
	public int findNum(int[] num) {
		int len = num.length;
		if(len == 0) return -1;
		int times = 1;
		int result = num[0];
		for(int i = 1; i < len; i++) {
			if(num[i] == result) times++;
			else 
				times--;
			if(times == 0) {
				result = num[i];
				times = 1;
			}
		}
		
		times = 0;
		for(int i = 0; i < len; i++)
			if(num[i] == result) 
				times++;
		if(times*2 <= len) return -1;
		return result;
	}
	
	public int find(int[] num) {
		int len = num.length;
		if(len == 0) return -1;
		int can1 = 0, can2 = 0;
		int times1 = 0, times2 = 0;
		for(int i = 0; i < len; i++) {
			if(times1 == 0) {
				can1 = num[i];
				times1 = 1;
			} else if(times2 == 0) {
				can2 = num[i];
				times2 = 1;
			} else {
				if(can1 == num[i]) 
					times1++;
				else if(can2 == num[i]) 
					times2++;
				else {
					times1--;
					times2--;
				}
			}
		}
		return times1>times2?can1:can2;
	}
}
