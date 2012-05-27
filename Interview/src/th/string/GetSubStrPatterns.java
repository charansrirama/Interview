package th.string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GetSubStrPatterns {
	
	public static Set<String>getSubStrPatterns(char[] input){
		if (input == null) {
			return null;
		}
		
		int[][] buffer = new int[input.length+1][input.length+1];
		for (int i = 0; i < buffer.length; i++) {
			for (int j = 0; j < buffer[0].length; j++) {
				buffer[i][j] = 0;
			}
		}
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (i!=j&&input[i]==input[j]) {
					buffer[i+1][j+1]=buffer[i][j]+1;
				}
			}
		}

		Set<String> output = new HashSet<String>();
		for (int i = 1; i < buffer.length; i++) {
			for (int j = 1; j < buffer[0].length; j++) {
				if (buffer[i][j] > 1) {
					if (i == input.length||j == input.length || buffer[i+1][j+1] == 0) {
						char[] substr = new char[buffer[i][j]];
						System.arraycopy(input, i-buffer[i][j], substr, 0, buffer[i][j]);
						addToOutput(output, new String(substr));
					}
				}
			}
		}
		return output;
	}

	private static void addToOutput(Set<String> output, String str) {
		if(output == null || str == null){
			return;
		}
	
		
		for (int i = 2; i <= str.length(); i++) {
			for (int j = 0; i+j <= str.length(); j++) {
				output.add(str.substring(j,j+i));
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "aabcdadabc";
		Set<String> result = getSubStrPatterns(test.toCharArray());
		Iterator ite = result.iterator();
		while(ite.hasNext()){
			System.out.println(ite.next());
		}
	}

}
