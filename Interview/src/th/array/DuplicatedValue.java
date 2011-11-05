package th.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DuplicatedValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Integer> test = new HashMap<Integer, Integer>();
		int array[] = { 3, 3, 3, 1, 5, 8, 11, 4, 5 };
		for(int i = 0; i < array.length; ++i) {
			if(test.containsKey(array[i])) {
				test.put(array[i], test.get(array[i])+1);
			} else {
				test.put(array[i], 1);
			}
		}
		for(Iterator<Integer> iterator = test.keySet().iterator(); iterator.hasNext();) {
			int key = (Integer)iterator.next();
			
			int value = (Integer)test.get(key);
			if(value > 1) {
				System.out.println(key + " with " + value + " times");
			}
		}
	}

}
