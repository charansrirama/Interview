package th.facebook;

public class RemoveDuplicate {

	public static String removeDuplicate(String s){
		char temp[] = s.toCharArray();
		int flag[] = new int[26];
		int mark = 0;
		for(int i = 0; i < temp.length; i++) {
			int index = temp[i]-'a';
			if(flag[index] == 0){
				flag[index] = 1;
				char tmp = temp[i];
				temp[i] = temp[mark];
				temp[mark] = tmp;
				mark++;
			}
		}
		return new String(temp, 0, mark);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(removeDuplicate("aab"));
		System.out.println(removeDuplicate(""));
		System.out.println(removeDuplicate("aaa"));
		System.out.println(removeDuplicate("abcdabcd"));
		System.out.println(removeDuplicate("abcdade"));
	}

}
