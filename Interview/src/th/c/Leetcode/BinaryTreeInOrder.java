package th.c.Leetcode;

import java.util.*;

// AC
public class BinaryTreeInOrder {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;  
        while(!stack.isEmpty() || curr != null) {
            if(curr != null){ 
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
}
