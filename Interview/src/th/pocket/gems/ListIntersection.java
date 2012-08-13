package th.pocket.gems;

public class ListIntersection {

	private class Node {
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	
	public Node intersectionNode(Node na, Node nb) {
		Node a = na;
		Node b = nb;
		int lenA = 0, lenB = 0;
		
		while(a != null) {
			lenA++;
			a = a.next;
		}
		
		while(b != null) {
			lenB++;
			b = b.next;
		}
		
		a = na; b = nb;
		if(lenA > lenB) {
			int diff = lenA-lenB;
			while(diff != 0) {
				a = a.next;
				diff--;
			}
		} else if(lenB > lenA) {
			int diff = lenB-lenA;
			while(diff != 0) {
				b = b.next;
				diff--;
			}
		}
		
		while(a != null && b != null) {
			if(a == b) 
				return a;
			else {
				a = a.next;
				b = b.next;
			}
		}
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
