package th.c.DP;

/*
 * From (0,0) => (x,y) 
 * How many ways a robot could walk from 0,0 to x,y
 */

import java.util.Arrays;

public class RobotWalk {
	
	public static int robotWalkPath(int x, int y) {
		if(x <= 0 || y <= 0) return 0;
		int[][] map = new int[x][y];
		Arrays.fill(map[x-1], 1);
		for(int i = 0; i < x; i++) {
			map[i][y-1] = 1;
		}
		
		for(int i = x-2; i >= 0; i--) {
			for(int j = y-2; j >= 0; j--) {
				map[i][j] = map[i+1][j] + map[i][j+1];
			}
		}
		
		return map[0][0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(robotWalkPath(2,2));
		System.out.println(robotWalkPath(1,1));
		System.out.println(robotWalkPath(1,4));
		System.out.println(robotWalkPath(4,1));
		System.out.println(robotWalkPath(3,3));
	}

}
