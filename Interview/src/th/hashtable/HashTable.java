package th.hashtable;

public class HashTable {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem   = new DataItem(-1);
	}
	
	public int hashFunc(int key) {
		return key%arraySize;
	}
	
	public int hashFunc2(int key) {
		return 5 - key%5;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class DataItem {
	private int iData;
	
	public DataItem(int ii) {
		iData = ii;
	}
	
	public int getKey() {
		return iData;
	}
}