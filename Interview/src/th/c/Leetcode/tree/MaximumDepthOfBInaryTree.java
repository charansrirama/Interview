package th.c.Leetcode.tree;

import java.util.*;

// AC
public class MaximumDepthOfBInaryTree {

	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
	
	public int maxDepth2(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int length = 0;
		q.offer(root);
		while(!q.isEmpty()) {
			length++;
			int len = q.size();
			for(int i = 0; i < len; i++) {
				TreeNode tmp = q.poll();
				if(tmp.left != null) q.offer(tmp.left);
				if(tmp.right != null) q.offer(tmp.right);
			}
		}
		return length;
	}
}
