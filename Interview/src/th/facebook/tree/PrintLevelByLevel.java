package th.facebook.tree;

import java.util.*;

public class PrintLevelByLevel {
	
	public static void printLevelByLevel(Node root) {
		if(root == null) {
			System.out.println();
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			for(int i = 0; i < q.size(); i++) {
				Node t = q.poll();
				if(t.leftChild != null) q.add(t.leftChild);
				if(t.rightChild != null) q.add(t.rightChild);
				System.out.print(t.number + " ");
			}
			System.out.println();
		}
			
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
