package interviewstreet.evernote;

import java.util.*;

public class FrequentTerms {
	//6/10
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		Scanner reader = new Scanner(System.in);

		int N = Integer.parseInt(reader.nextLine());
		for (int i = 0; i < N; i++) {
			String terms = reader.nextLine().trim();
			if (map.containsKey(terms)) {
				int freq = map.get(terms);
				map.remove(terms);
				map.put(terms, freq + 1);
			} else {
				map.put(terms, 1);
			}
		}
		int size = reader.nextInt();

		LinkedHashMap sorted = sortHashMapByValuesD(map);
		System.out.println(sorted);
		String[] key = new String[sorted.size()];
		int[] value = new int[sorted.size()];
		Iterator it = sorted.entrySet().iterator();
		int i = sorted.size() - 1;
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			key[i] = (String) entry.getKey();
			value[i--] = (Integer) entry.getValue();
		}

		TreeMap<Integer, TreeSet<String>> tm = new TreeMap<Integer, TreeSet<String>>();
		for (i = 0; i < key.length; i++) {
			if (tm.containsKey(value[i])) {
				TreeSet<String> set = tm.get(value[i]);
				tm.remove(value[i]);
				set.add(key[i]);
				tm.put(value[i], set);
			} else {
				TreeSet<String> set = new TreeSet<String>();
				set.add(key[i]);
				tm.put(value[i], set);
			}
		}

		NavigableMap<Integer, TreeSet<String>> nm = tm.descendingMap();
		Iterator tmi = nm.entrySet().iterator();
		int count = 0;
		while (tmi.hasNext()) {
			Map.Entry entry = (Map.Entry) tmi.next();
			TreeSet<String> ts = (TreeSet<String>) entry.getValue();
			for (String st : ts) {
				if(count < size) {
					System.out.println(st);
					count++;
				}else 
					break;
			}
		}
	}

	public static LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
		List mapKeys = new ArrayList(passedMap.keySet());
		List mapValues = new ArrayList(passedMap.values());
		Collections.sort(mapValues);
		Collections.sort(mapKeys);

		LinkedHashMap sortedMap = new LinkedHashMap();

		Iterator valueIt = mapValues.iterator();
		while (valueIt.hasNext()) {
			Object val = valueIt.next();
			Iterator keyIt = mapKeys.iterator();

			while (keyIt.hasNext()) {
				Object key = keyIt.next();
				String comp1 = passedMap.get(key).toString();
				String comp2 = val.toString();

				if (comp1.equals(comp2)) {
					passedMap.remove(key);
					mapKeys.remove(key);
					sortedMap.put((String) key, (Integer) val);
					break;
				}
			}
		}
		return sortedMap;
	}
}
