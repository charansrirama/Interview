package th.c.HashTable;

import java.util.Locale;

public class HashTable {
	private final static int INITIAL_SIZE = 50;
	private String[] elements;
	private int capacity;
	
	public HashTable() {
		this(INITIAL_SIZE);
	}
	
	public HashTable(int n) {
		int size = 2*n;
		elements = new String[getNearestPrime(size)];
	}
	
	public boolean insert(String value) {
		if(loadFactor() >= 0.75) 
			reHash();
		return insert(elements, value);
	}
	
	private boolean insert(String[] strArray, String value) {
		int hash_key = hash(value, strArray.length);
		int increment = 1;
		
		int probe_counter = 0;
		int hash_mid = (strArray.length+1)/2;
		
		while(true) {
			if(probe_counter > hash_mid) 
				return false;
			String tmp = strArray[hash_key];
			if(tmp == null) 
				break;
			else if(tmp.equals(value)) 
				return false;
			else {
				hash_key = (hash_key + increment) % strArray.length;
				increment+=2;
				probe_counter++;
			}
		}
		strArray[hash_key] = value;
		capacity++;
		return true;
	}
	
	public boolean lookUp(String str) {
		int hash_key = hash(str, elements.length);
		int increment = 1;
		
		int probe_counter = 0;
		int hash_mid = (elements.length + 1)/2;
		
		while(true) {
			if(probe_counter > hash_mid) 
				return false;
			String tmp = elements[hash_key];
			if(tmp == null) 
				break;
			else if(tmp.equals(str))
				return true;
			else {
				hash_key = (hash_key + increment) % elements.length;
				increment += 2;
				probe_counter++;
			}
		}
		return false;
	}
	
	public int length() {
		return elements.length;
	}
	
	public int getNum() {
		return capacity;
	}
	
	private float loadFactor() {
		return (float) capacity / elements.length;
	}
	
	private int getNearestPrime(int size) {
		boolean isPrime = checkPrime(size);
		while(!isPrime) {
			size++;
			isPrime = checkPrime(size);
		}
		return size;
	}
	
	private boolean checkPrime(int n) {
		if(n < 1) return false;
		if(n%2 == 0) return false;
		for(int i = 3; i*i <= n; i+=2) {
			if(n%i == 0) return false;
		}
		return true;
	}
	
	private int hash(String word, int size) {
		word = word.toLowerCase(Locale.ENGLISH);
		int hashValue = 0;
		for(int i = 0; i < word.length(); i++) 
			hashValue = ((hashValue*32) + (word.charAt(i)-'a'))%size;
		if(hashValue < 0) 
			hashValue = hashValue + size;
		return hashValue;
	}
	
	private void reHash() {
		capacity = 0;
		String[] newArray = new String[getNearestPrime(2*elements.length)];
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] != null) 
				insert(newArray, elements[i]);
		}
		elements = newArray;
	}
}
