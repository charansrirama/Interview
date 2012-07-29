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
}
