package th.c.TreeProblem;

import java.util.Collection;
import java.util.LinkedList;

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode(' ');
	}
	
	public void insert(String s) {
		TrieNode curr = root;
		if(s.length() == 0) 
			curr.marker = true;
		for(int i = 0; i < s.length(); i++) {
			TrieNode child = curr.subNode(s.charAt(i));
			if(child != null) {
				curr = child;
			} else {
				curr.child.add(new TrieNode(s.charAt(i)));
				curr = curr.subNode(s.charAt(i));
			}
			if(i == s.length()-1)
				curr.marker = true;
		}
	}
	
	public boolean search(String s) {
		TrieNode curr = root;
		while(curr != null) {
			for(int i = 0; i < s.length(); i++) {
				if(curr.subNode(s.charAt(i)) == null) 
					return false;
				else 
					curr = curr.subNode(s.charAt(i));
			}
			if(curr.marker == true)
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
		System.out.println(t.search("ab"));
	}
}

class TrieNode {
	char content;
	boolean marker;
	Collection<TrieNode> child;
	
	public TrieNode(char c) {
		child = new LinkedList<TrieNode>();
		marker = false;
		content = c;
	}
	
	public TrieNode subNode(char c) {
		if(child != null) {
			for(TrieNode eachChild : child) {
				if(eachChild.content == c) {
					return eachChild;
				}
			}
		}
		return null;
	}
}