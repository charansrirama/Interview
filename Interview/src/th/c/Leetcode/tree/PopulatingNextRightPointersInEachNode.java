package th.c.Leetcode.tree;

public class PopulatingNextRightPointersInEachNode {

	public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root != null) 
            helper(root, null);
    }
    
    public void helper(TreeLinkNode node, TreeLinkNode silibing) {
        node.next = silibing;
        TreeLinkNode l = node.left;
        TreeLinkNode r = node.right;
        if(l == null && r == null) return;
        
        while(silibing != null) {
            if(silibing.left != null) { silibing = silibing.left; break;}
            if(silibing.right != null) { silibing = silibing.right; break;}
            silibing = silibing.next;
        }
        
        if(r != null) {
            helper(r, silibing);
            silibing = r;
        }
        if(l != null) {
            helper(l, silibing);
        }
    }
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
