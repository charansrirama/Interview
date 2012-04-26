package th.facebook;

import java.util.*;

public class GroupOne {

	/*
	 * Given a matrix with 1's and 0's, find the number of groups of 1's. 
	 * A group is defined by horiz/vertically adjacent 1's.
	 */
	
	public static void findGroup(int[][] matrix) {
		HashMap<Integer, ArrayList<Pair>> map = new HashMap<Integer, ArrayList<Pair>>();
		
		int groupid = 1;
		
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] group = new int[row][col];
		
		if(matrix[0][0] == 1) {
			Pair p = new Pair(0,0);
			ArrayList<Pair> al = new ArrayList<Pair>();
			al.add(p);
			map.put(groupid, al);
			group[0][0] = groupid;
		}
		
		for(int i = 1; i < row; i++) {
			if(matrix[i][0] == 1 && matrix[i-1][0] == 1) {
				ArrayList<Pair> al = (ArrayList<Pair>)map.get(group[i-1][0]);
				al.add(new Pair(i, 0));
				map.put(group[i-1][0], al);
			} else if(matrix[i][0] == 1) {
				ArrayList<Pair> al = new ArrayList<Pair>();
				al.add(new Pair(i, 0));
				groupid++;
				map.put(groupid, al);
				group[i][0] = groupid;
			}
		}
		
		for(int i = 1; i < col; i++) {
			if(matrix[0][i] == 1 && matrix[0][i-1] == 1) {
				ArrayList<Pair> al = (ArrayList<Pair>)map.get(group[0][i-1]);
				al.add(new Pair(0, i));
				map.put(group[0][i-1], al);
			} else if(matrix[0][i] == 1) {
				ArrayList<Pair> al = new ArrayList<Pair>();
				al.add(new Pair(0, i));
				groupid++;
				map.put(groupid, al);
				group[0][i] = groupid;
			}
		}
		
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				if(matrix[i][j] == 1) {
					if(matrix[i-1][j] == 1 && matrix[i][j-1] != 1) {
						ArrayList<Pair> al = (ArrayList<Pair>)map.get(group[i-1][j]);
						al.add(new Pair(i, j));
						map.put(group[i-1][j], al);
						group[i][j] = group[i-1][j];
					}
					else if(matrix[i][j-1] == 1 && matrix[i-1][j]!=1){
						ArrayList<Pair> al = (ArrayList<Pair>)map.get(group[i][j-1]);
						al.add(new Pair(i, j));
						map.put(group[i][j-1], al);
						group[i][j] = group[i][j-1];
					}
					else if(matrix[i][j-1] == 1 && matrix[i-1][j] == 1) {
						int id1 = group[i][j-1];
						int id2 = group[i-1][j];
						int min = Math.min(id1, id2);
						int max = Math.max(id1, id2);
						for(Pair p : map.get(max)){
							group[p.x][p.y] = min;
						}
						ArrayList<Pair> re = union(map.get(id1), map.get(id2));
						re.add(new Pair(i, j));
						map.remove(id1);
						map.remove(id2);
						map.put(min, re);
						group[i][j] = min;
					} else {
						ArrayList<Pair> al = new ArrayList<Pair>();
						al.add(new Pair(i, j));
						groupid++;
						group[i][j] = groupid;
					}
				}
			}
		}
		
		Iterator iter = map.keySet().iterator();
		while(iter.hasNext()) {
			int key = (Integer)iter.next();
			ArrayList<Pair> al = (ArrayList<Pair>)map.get(key);
			System.out.print(key + ": ");
			for(Pair p : al) {
				System.out.print("[" + p.x + ", " + p.y + "]");
			}
			System.out.println();
		}
	}
	
	private static ArrayList<Pair> union(ArrayList<Pair> a1, ArrayList<Pair> a2) {
		ArrayList<Pair> re = a1;
		for(Pair p : a2) {
			re.add(p);
		}
		return re;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}

class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}