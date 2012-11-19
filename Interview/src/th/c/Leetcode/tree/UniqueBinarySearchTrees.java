package th.c.Leetcode.tree;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n > 1) {
			int sum = 0;
			for(int i = 0; i <= n; i++) {
				int l = numTrees(i-1);
				int r = numTrees(n-i);
				sum += l*r;
			}
			return sum;
		} else
			return 1;
    }
}
