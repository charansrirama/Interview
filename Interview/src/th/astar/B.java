package th.astar;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int expNum = cin.nextInt();
		for(int i = 0; i < expNum; i++) {
			int hubNum = cin.nextInt();
			int count = 0;
			for(int j = 0; j < hubNum; j++) {
				count += cin.nextInt()-1;
			}
			System.out.println(count+1);
		}
	}

}
