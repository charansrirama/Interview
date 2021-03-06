package th.c.TreeProblem;

public class ConstructTree {

	public Node InAndPre(int[] inorder, int[] preorder, int inorderIndex,
			int preorderIndex, int len) {
		if (len == 0)
			return null;
		Node root = new Node(preorder[preorderIndex]);
		int rootIndex = 0;
		for (int i = inorderIndex; i < inorder.length; i++) {
			if (inorder[i] == preorder[preorderIndex])
				break;
			else
				rootIndex++;
		}
		root.left = InAndPre(inorder, preorder, inorderIndex,
				preorderIndex + 1, rootIndex);
		root.right = InAndPre(inorder, preorder, inorderIndex + rootIndex + 1,
				preorderIndex + rootIndex + 1, len - (rootIndex + 1));

		return root;
	}

	public Node InAndPost(int[] inorder, int[] postorder, int inorderIndex,
			int postorderIndex, int len) {
		if (len == 0)
			return null;
		Node root = new Node(postorder[postorderIndex]);
		int rootIndex = 0;
		for (int i = inorderIndex; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorderIndex])
				break;
			else
				rootIndex++;
		}
		root.left = InAndPost(inorder, postorder, inorderIndex,
				len - rootIndex, rootIndex);
		root.right = InAndPost(inorder, postorder,
				inorderIndex + rootIndex + 1, postorderIndex - 1, len
						- (rootIndex + 1));
		return root;
	}
}
