package th.astar;

import java.util.*;

public class D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int num = Integer.parseInt(cin.nextLine());
		for(int i = 0; i < num; i++) {
			String line = cin.nextLine();
			int hour = Integer.parseInt(line.split(":")[0]);
			int min  = Integer.parseInt(line.split(":")[1]);
			if(min != 0) System.out.println(0);
			else {
				System.out.println((hour+12)%24 == 0?24:(hour+12)%24);
			}
		}
	}

}
