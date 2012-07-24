package th.c.cracking;

import java.util.*;

public class Rand7 {
	public int rand5() {
		return new Random().nextInt(5);
	}
	
	public int rand7() {
		while(true){
			int r1 = 2*rand5();
			int r2 = rand5();
			if(r2 != 4) {
				int rand1 = r2%2;
				int num = r1+rand1;
				if(num < 7) 
					return num;
			}
		}
	}
}
