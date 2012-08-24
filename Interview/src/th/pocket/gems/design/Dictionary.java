package th.pocket.gems.design;

import java.util.*;

public class Dictionary {
	int pages;
	List<Word> words;
	Trie tree;
	
	public Dictionary(int pages) {
		this.pages = pages;
		words = new ArrayList<Word>();
		tree = new Trie();
	}
	
	public void insert() {
		for(Word w : words) {
			tree.insert(w.content, w.definition);
		}
	}
	
	public String lookup(String word) {
		return tree.search(word);
	}
}

class Word {
	int page;
	String content;
	String definition;
	
	public Word(int p, String c, String d) {
		this.page = p;
		this.content = c;
		this.definition = d;
	}
}

class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode(' ');
	}
	
	public void insert(String s, String desc) {
		TrieNode curr = root;
		if(s.length() == 0) 
			curr.marker = true;
		for(int i = 0; i < s.length(); i++) {
			TrieNode child = curr.subNode(s.charAt(i));
			if(child != null) {
				curr = child;
			} else {
				curr.children.add(new TrieNode(s.charAt(i)));
				curr = curr.subNode(s.charAt(i));
			}
			if(i == s.length()-1) {
				curr.marker = true;
				curr.description = desc;
			}
		}
	}
	
	public String search(String s) {
		TrieNode curr = root;
		while(curr != null) {
			for(int i = 0; i < s.length(); i++) {
				if(curr.subNode(s.charAt(i)) == null) {
					return null;
				} else {
					curr = curr.subNode(s.charAt(i));
				}
			}
			if(curr.marker == true) {
				return curr.description;
			} else 
				return null;
		}
		return null;
	}
}

class TrieNode {
	char content;
	boolean marker;
	String description;
	Collection<TrieNode> children;
	
	public TrieNode(char c) {
		children = new LinkedList<TrieNode>();
		marker = false;
		content = c;
	}
	
	public TrieNode subNode(char c)  {
		if(children != null) {
			for(TrieNode child : children) {
				if(child.content == c) {
					return child;
				}
			}
		}
		return null;
	}
}
