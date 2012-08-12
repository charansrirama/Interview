package th.c.TreeProblem;

import java.util.*;

/*
 * This is an Amazon interview question. Can any one give an algorithm to do this?
 * There is a binary tree with the following properties:
 * All of its inner node have the value 'N', and all the leaves have the value 'L'.
 * Every node either has two children or has no child.
 * Given its preorder, construct the tree and return the root node.
 */
public class ConstructFromPreorder {

	public static Node buildTree(List<Character> tokens) {
		char val = tokens.remove(0);
		if(val == (int)'L') {
			return new Node(val, null, null);
		} else {
			return new Node(val, buildTree(tokens), buildTree(tokens));
		}
	}
	
	public static void main(String[] args) {
		List<Character> tokens = new LinkedList<Character>();
		String input = "NNLLL";
		for(int i = 0; i < input.length(); i++) tokens.add(input.charAt(i));
		System.out.println(buildTree(tokens));
	}
}
