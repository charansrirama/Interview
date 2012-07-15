package th.facebook;

import java.util.*;

public class PrintBinary {

	public static void printBinaryWithLength(int n) {
		System.out.print(getBinaryWithLength("", n));
	}

	private static ArrayList<String> getBinaryWithLength(String prefix, int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n == 0) {
			result.add(prefix);
			return result;
		}
		ArrayList<String> list1 = getBinaryWithLength(prefix + "0", n - 1);
		ArrayList<String> list2 = getBinaryWithLength(prefix + "1", n - 1);

		result.addAll(list1);
		
//		for(int i = 0; i < list2.size(); i++){
//			result.add(list2.get(i));
//		}
		for (int i = list2.size() - 1; i >= 0; i--)
			result.add(list2.get(i));
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBinaryWithLength(3);
	}

}
