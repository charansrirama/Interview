package th.String;

public class StringReverser {

	public static void reverseString(char input[], int start, int end) {
		char temp;
		while(end > start) {
			temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			
			++start; --end;
		}
	}
	
	public static char[] reverseWord(char input[]) {
		int start = 0, end = 0, length = input.length;
		
		reverseString(input, start, length-1);
		
		while (end < length) {
			if(input[end] != ' ') {
				start = end;
				while (end < length && input[end] != ' '){
					++end;
				}
				--end;
				reverseString(input, start, end);
			}
			++end;
		}
		return input;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "this is a test string";
		System.out.println(reverseWord(test.toCharArray()));
	}

}
