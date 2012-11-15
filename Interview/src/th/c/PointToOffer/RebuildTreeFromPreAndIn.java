package th.c.PointToOffer;

public class RebuildTreeFromPreAndIn {
	
	public static TreeNode rebuild(int[] pre, int ps, int pe, int[] in, int is, int ie) {
		if(ps > pe || is > ie) return null;
		if(ps == pe || is == ie) 
			return new TreeNode(pre[ps]);
		TreeNode node = new TreeNode(pre[ps]);
		int index = findIndex(in, pre[ps]);
		if(index == -1) return null;
		int offset = index - is;
		node.left = rebuild(pre, ps+1, ps+offset, in, is, is+offset);
		node.right = rebuild(pre, ps+offset+1, pe, in, index+1, ie);
		return node;
	}
	
	public static int findIndex(int[] A, int v) {
		for(int i = 0; i < A.length; i++) 
			if(A[i] == v) 
				return i;
		return -1;
	}
}
