package th.c.PointToOffer;

public class ReplaceSpace {

	public static String replaceSpace(String str) {
		if(str == null || str.length() == 0) return str;
		
		char[] ori = str.toCharArray();
		int s = 0;
		for(int i = 0; i < ori.length; i++) {
			if(ori[i] == ' ') s++;
		}
		
		char[] result = new char[ori.length + 2*s];
		int i = ori.length-1;
		int j = result.length-1;
		while(i >= 0 && j >= 0) {
			if(ori[i] == ' ') {
				result[j--] = '0';
				result[j--] = '2';
				result[j--] = '%';
				i--;
			} else {
				result[j--] = ori[i--];
			}
		}
		return new String(result);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test1 = "Hello World";
		String test2 = "Hello World again";
		String test3 = "Hello";
		System.out.println(replaceSpace(test1));
		System.out.println(replaceSpace(test2));
		System.out.println(replaceSpace(test3));
	}

}
