package th.astar;

import java.util.*;

public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		float result = 0;
		for(int i = 0; i < 12; i++) {
			result += cin.nextFloat();
		}
		int tmp = (int)((result/12)*100);
		float remain = (result/12)*100-tmp;
		if(remain >= 0.5) {
			tmp++;
		}
		System.out.println("$" + (float)tmp/100);
	}

}
