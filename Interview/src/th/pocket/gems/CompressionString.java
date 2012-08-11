package th.pocket.gems;

public class CompressionString {

	public static String compression(String str) {
		if(str.length() <= 1) return str;
		StringBuilder result = new StringBuilder();
		
		int count = 1;
		char c = str.charAt(0);
		for(int i = 1; i < str.length(); i++) {
			if(c == str.charAt(i)){
				count++;
			} else {
				result.append(count);
				result.append(c);
				c = str.charAt(i);
				count = 1;
			}
		}
		result.append(count);
		result.append(c);
		return result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("aabcccc: " + compression("aabcccc"));
		System.out.println("aaaacccccdd: " + compression("aaaacccccdd"));
		System.out.println(" " + compression(""));
	}

}
