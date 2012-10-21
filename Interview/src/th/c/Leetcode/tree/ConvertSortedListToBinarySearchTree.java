package th.c.Leetcode.tree;

// AC
public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
        int[] array = toArray(head);
        return helper(array, 0, array.length-1);
    }
	
	private TreeNode helper(int[] array, int start, int end) {
		if(start > end) return null;
		if(start == end) {
			return new TreeNode(array[start]);
		} else {
			int mid = (start + end)/2;
			TreeNode root = new TreeNode(array[mid]);
			root.left = helper(array, start, mid-1);
			root.right = helper(array, mid+1, end);
			return root;
		}
	}
	
	private int getLength(ListNode head) {
		int length = 0; 
		while(head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
	
	private int[] toArray(ListNode head) {
		int[] array = new int[getLength(head)];
		int i = 0; 
		while(head != null) {
			array[i++] = head.val;
			head = head.next;
		}
		return array;
	}
}
