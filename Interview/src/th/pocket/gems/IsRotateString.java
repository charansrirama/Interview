package th.pocket.gems;

public class IsRotateString {

	public static boolean isSubString(String word, String longword) {
		int lenw = word.length();
		int lenl = longword.length();
		for(int i = 0; i < lenl - lenw + 1; i++) {
			if(longword.charAt(i) == word.charAt(0)) {
				int j = 0;
				for(; j < lenw; j++) {
					if(longword.charAt(i+j) != word.charAt(j)) 
						break;
				}
				if(j == lenw && longword.charAt(i+j-1) == word.charAt(j-1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isRotate(String original, String rotated) {
		if(original.length() != rotated.length()) {
			return false;
		}
		if(original.length() == 1 && original.equals(rotated)) {
			return true;
		}
		int len = original.length();
		for(int i = 1; i < len; i++) {
			String front = original.substring(0, i);
			String back = original.substring(i);
			
			String rfront = rotated.substring(len-i);
			String rback = rotated.substring(0, len-i);
			if(isSubString(front, rfront) && isSubString(back, rback))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isRotate("waterbottle", "erbottlewat"));
		System.out.println(isRotate("waterbottle", "erbottletat"));
		System.out.println(isRotate("ww", "ww"));
		System.out.println(isRotate("w", "w"));
	}
}
