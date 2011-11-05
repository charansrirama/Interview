package th.String;

public class RemoveChars {

	public static String removeChars(String input, String remove) {
		StringBuilder result = new StringBuilder();
		char[] in = input.toCharArray();
		char[] re = remove.toCharArray();
		
		boolean[] flags = new boolean[128];
		
		for(int i = 0; i < 128; i++) 
			flags[i] = true;
		
		for(int i = 0; i < re.length; i++) 
			flags[(int)re[i]] = false;
		
		for(int i = 0; i < in.length; i++) {
			if(flags[(int)in[i]]) {
				result.append(in[i]);
			}
		}
		
		return result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(removeChars("abcdefghijklmn", "giklmn"));
	}

}
