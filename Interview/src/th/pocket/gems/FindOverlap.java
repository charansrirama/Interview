package th.pocket.gems;

public class FindOverlap {

	public static String findOverlap(String a, String b) {
		int[] flag = new int[26];
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < a.length(); i++) {
			flag[a.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < b.length(); i++) {
			if(flag[b.charAt(i) - 'a'] > 0) {
				result.append(b.charAt(i));
				flag[b.charAt(i) - 'a']--;
			}
		}
		return result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Case 1:" + findOverlap("abcda", "aba"));
		System.out.println("Case 2:" + findOverlap("", "aaaa"));
	}

}
