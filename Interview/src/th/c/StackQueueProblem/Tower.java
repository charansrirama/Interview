package th.c.StackQueueProblem;

import java.util.Stack;

public class Tower {

	private Stack<Integer> disks;
	private int index;
	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d) {
		if(!disks.empty() && d > disks.peek()) {
			System.out.print("Error");
		} else {
			disks.push(d);
		}
	}
	
	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer) {
		if( n > 0) {
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			moveDisks(n-1, destination, this);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		Tower[] towers = new Tower[3];
		for(int i = 0; i < n; i++) {
			towers[i] = new Tower(i);
		}
		
		for(int i = n-1; i >= 0; i--) {
			towers[0].add(i);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}
