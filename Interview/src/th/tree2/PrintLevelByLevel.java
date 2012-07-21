package th.tree2;

import java.util.LinkedList;
import java.util.Queue;



public class PrintLevelByLevel {

	public static void printLevelByLevel(Node root) {
		if(root == null) {
			System.out.println("null");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				Node node = queue.poll();
				System.out.print(node.number + " ");
				if (node.leftChild != null) {
					queue.add(node.leftChild);
				}
				if (node.rightChild != null) {
					queue.add(node.rightChild);
				}
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
