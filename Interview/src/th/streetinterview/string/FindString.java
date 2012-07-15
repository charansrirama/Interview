package th.streetinterview.string;

import java.util.*;

public class FindString {
	
	public static void addToSet(String str, Set set) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = i+1; j <= str.length(); j++) {
				set.add(str.substring(i, j));
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int stringNum = Integer.parseInt(cin.nextLine());
		Set<String> set = new TreeSet<String>();
		for(int i = 0; i < stringNum; i++) {
			addToSet(cin.nextLine(), set);
		}
		String[] array = new String[set.size()];
		int count = 0;
		for(String s : set) {
			array[count++] = s;
		}
		Arrays.sort(array);
//		for(String s : array) {
//			System.out.println(s);
//		}
		int queryNum = Integer.parseInt(cin.nextLine());
		for(int i = 0; i < queryNum; i++) {
			int query = Integer.parseInt(cin.nextLine());
			if(query > array.length) System.out.println("INVALID");
			else {
				System.out.println(array[query-1]);
			}
		}
	}

}
