package th.c.codility;

import java.util.*;

public class VisibleNode {

	public List<Node> findVisible(Node root) {
		List<Node> result = new ArrayList<Node>();
		if(root == null) return result;
		help(result, root, root.val);
		return result;
	}
	
	public void help(List<Node> result, Node node, int val) {
		if(node == null) return;
		if(node.val > val) {
			result.add(node);
			help(result, node.left, node.val);
			help(result, node.right, node.val);
		} else {
			help(result, node.left, val);
			help(result, node.right, val);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node {
	Node left;
	Node right;
	int val;
	
	public Node (int v) {
		val = v;
		left = null;
		right = null;
	}
}
