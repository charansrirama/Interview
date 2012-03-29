package th.tree;

public class TreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST bst = new BST();
		
		bst.insert(10);
		bst.insert(3);
		bst.insert(1);
		bst.insert(111);
		bst.insert(4);
		bst.insert(11);
		bst.insert(1111);
		bst.insert(11222);
		
		TreePrinter.inorderPrint(bst.getRoot());
		System.out.println();
		MirrorTree.mirror(bst.getRoot());
		TreePrinter.inorderPrint(bst.getRoot());
	}

}
