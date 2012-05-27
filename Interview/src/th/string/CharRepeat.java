package th.string;

public class CharRepeat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "adfaslkfjlaskjdflkasjdlfajlsfadfja";
		char[] temp = input.toCharArray();
		for(int i = 0; i < temp.length; i++) {
			for(int j = i+1; j < temp.length; j++) {
				if(temp[i] > temp[j]) {
					char c = temp[i];
					temp[i] = temp[j];
					temp[j] = c;
				}
			}
		}
		for(char c : temp) {
			System.out.println(c);
		}
	}

}
