package th.facebook.linkedlist;

public class Meet {

	public static boolean isMeet(Node n1, Node n2) {
		Node it1 = n1, it2 = n2;
		int len1 = 0, len2 = 0;
		while(it1 != null) {
			len1++;
			it1 = it1.next;
		}
		while(it2 != null) {
			len2++;
			it2 = it2.next;
		}
		int diff = 0;
		it1 = n1; 
		it2 = n2;
		if(len1 > len2) {
			diff = len1 - len2;
			while(diff > 0) {
				it1 = it1.next;
				diff--;
			}
		}
		if(len2 > len1) {
			diff = len2 - len1;
			while(diff > 0) {
				it2 = it2.next;
				diff--;
			}
		}
		while(it1 != null && it2 != null) {
			if(it1 == it2) return true;
			it1 = it1.next;
			it2 = it2.next;
		}
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
