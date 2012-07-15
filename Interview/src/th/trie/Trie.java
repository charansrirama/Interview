package th.trie;

/**
 * shijinliang Feb 6, 2012 Interview
 **/
public class Trie {
	private Node root;

	public Trie() {
		root = new Node(' ');
	}

	public void insert(String s) {
		Node current = root;
		if (s.length() == 0)
			current.marker = true;
		for (int i = 0; i < s.length(); i++) {
			Node child = current.subNode(s.charAt(i));
			if (child != null) {
				current = child;
			} else {
				current.child.add(new Node(s.charAt(i)));
				current = current.subNode(s.charAt(i));
			}
			if (i == s.length() - 1)
				current.marker = true;
		}
	}

	public boolean search(String s) {
		Node current = root;
		while (current != null) {
			for (int i = 0; i < s.length(); i++) {
				if (current.subNode(s.charAt(i)) == null)
					return false;
				else
					current = current.subNode(s.charAt(i));
			}
			if (current.marker == true)
				return true;
			else
				return false;
		}
		return false;
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("abcde");
		t.insert("aa");
		System.out.println(t.search("aa"));
	}
}
