package th.pocket.gems;

public class RemoveCharacter {

	public static String removeCharacter(String original, String remove) {
		int[] flag = new int['z' - 'A'];
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < remove.length(); i++) {
			flag[remove.charAt(i) - 'A']++;
		}
		for(int i = 0; i < original.length(); i++) {
			if(flag[original.charAt(i) - 'A'] == 0) {
				result.append(original.charAt(i));
			}
		}
		return result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Case 1: " + removeCharacter("abcdefghijk", "ajk"));
		System.out.println("Case 2: " + removeCharacter("aaaaaajljljljljljljl", "ajk"));
	}

}
