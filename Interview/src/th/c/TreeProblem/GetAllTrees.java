package th.c.TreeProblem;

import java.util.*;

public class GetAllTrees {
	
	static List<BinaryTree> GetAllTrees(int[] preorder, int start, int end) {
		List<BinaryTree> returnTrees = new ArrayList<BinaryTree>();
		
		if(start > end || end >= preorder.length || start < 0) {
			returnTrees.add(null);
			return returnTrees;
		}
		
		if(start == end) {
			returnTrees.add(new BinaryTree(preorder[start]));
			return returnTrees;
		}
		
		for(int i = -1; i < end-start; i++) {
			List<BinaryTree> leftChild = GetAllTrees(preorder, start+1, start+1+i);
			List<BinaryTree> rightChild = GetAllTrees(preorder, start+1+i+1, end);
			for(BinaryTree eachLeft : leftChild) {
				for(BinaryTree eachRight : rightChild) {
					BinaryTree tempRoot = new BinaryTree(preorder[start]);
					tempRoot.left = eachLeft;
					tempRoot.right = eachRight;
					returnTrees.add(tempRoot);
				}
			}
		}
		return returnTrees;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] testPreOrder = {1,2,3};
		List<BinaryTree> testResults = GetAllTrees(testPreOrder, 0, testPreOrder.length-1);
		for(BinaryTree eachFormedBT : testResults) {
			eachFormedBT.PrintInOrder();
		}
	}

}

class BinaryTree {
	int value;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int k) {
		value = k;
	}
	
	public void PrintInOrder() {
		inOrderTraversal(this);
		System.out.println();
	}
	
	private void inOrderTraversal(BinaryTree root) {
		if(root == null) return;
		inOrderTraversal(root.left);
		System.out.print(root.value);
		inOrderTraversal(root.right);
	}
}