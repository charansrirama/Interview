package th.hard;

import java.util.Date;
import java.util.Random;

public class Rand7 {
	
	public static int rand5(){
		Random rand = new Random();
		return rand.nextInt(5);
	}
	
	public static int rand7() {
		while(true) {
			int r1 = 2*rand5();
			int r2 = rand5();
			if(r2 != 4) {
				int rand1 = r2%2;
				int num = r1 + rand1;
				if(num < 7) return num;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 0; i <10; i++)
			System.out.println(rand7());
	}

}
