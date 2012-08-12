package th.pocket.gems;

public class PartitionList {
	
	public static LNode partition(LNode head, int x) {
		LNode beforeS = null;
		LNode beforeE = null;
		LNode afterS = null;
		LNode afterE = null;
		
		LNode curr = head;
		while(curr != null) {
			LNode next = curr.next;
			curr.next = null;
			if(curr.val < x) {
				if(beforeS == null) {
					beforeS = curr;
					beforeE = beforeS;
				} else {
					beforeE.next = curr;
					beforeE = beforeE.next;
				}
			} else {
				if(afterS == null) {
					afterS = curr;
					afterE = afterS;
				} else {
					afterE.next = curr;
					afterE = afterE.next;
				}
			}
			curr = next;
		}
		if(beforeS == null) return afterS;
		beforeE.next = afterS;
		return beforeS;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
