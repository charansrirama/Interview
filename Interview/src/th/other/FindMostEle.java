package th.other;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class FindMostEle {
    // 判断一个数组中出现次数最多的那个元素
    private static LinkedHashMap<String, Integer> map;

    public static LinkedHashMap<String, Integer> mostEle(String[] strArray) {
	map = new LinkedHashMap<String, Integer>();

	String str = "";
	int count = 0;
	int result = 0;

	for (int i = 0; i < strArray.length; i++)
	    str += strArray[i];

	for (int i = 0; i < strArray.length; i++) {
	    String temp = str.replaceAll(strArray[i], "");
	    count = (str.length() - temp.length()) / strArray[i].length();

	    if (count > result) {
		map.clear();
		map.put(strArray[i], count);
		result = count;
	    } else if (null == map.get(strArray[i]) && count == result)
		map.put(strArray[i], count);
	}
	return map;
    }

    public static void main(String args[]) {
	String[] strArray = { "11", "11", "2", "2", "4", "5", "4" };

	LinkedHashMap<String, Integer> result = mostEle(strArray);

	ArrayList<Integer> c = new ArrayList<Integer>(result.values());
	Set<String> s = result.keySet();

	System.out.print("一共有" + result.size() + "元素最多。它们分别是");
	System.out.print(s);
	System.out.println("，分别出现了" + c.get(0) + "次。");

    }
}
