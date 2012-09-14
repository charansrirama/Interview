package th.tree2;

import java.util.List;

/**
 * shijinliang Feb 19, 2012 Interview
 **/
public class InorderPreorderToBST {

	public Node constructBT(List preOrder, List inOrder, int preOrderIndex,
			int inOrderIndex, int length) {
		if (length == 0) {
			return null;
		}

		Node node = new Node();
		node.number = ((Integer) preOrder.get(preOrderIndex)).intValue();

		int rootIndex = 0;

		for (int count = inOrderIndex; count < inOrder.size(); count++) {
			int inOrderData = ((Integer) inOrder.get(count)).intValue();

			if (inOrderData == node.number)
				break;
			rootIndex++;
		}

		node.leftChild = constructBT(preOrder, inOrder, preOrderIndex + 1,
				inOrderIndex, rootIndex);
		node.rightChild = constructBT(preOrder, inOrder, preOrderIndex
				+ rootIndex + 1, inOrderIndex + rootIndex + 1, length
				- (rootIndex + 1));
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated metzhod stub

	}

}
