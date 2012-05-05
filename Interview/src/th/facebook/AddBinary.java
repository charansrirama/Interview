package th.facebook;

public class AddBinary {

	public static String addBinary(String a, String b) {
		int lena = a.length()-1;
		int lenb = b.length()-1;
		
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		
		int[] re = lena>lenb?new int[lena+1]:new int[lenb+1];
		int len = re.length-1;
		int carry = 0;
		while(lena>=0 && lenb>=0) {
			int da = ac[lena]-'0';
			int db = bc[lenb]-'0';
			carry = da+db+carry;
			re[len] = carry%2;
			carry /= 2;
			lena--; lenb--; len--;
		}
		
		while(lena>=0) {
			int da = ac[lena]-'0';
			carry = da+carry;
			re[len] = carry%2;
			carry /= 2;
			len--; lena--;
		}
		
		while(lenb>=0) {
			int db = bc[lenb]-'0';
			carry = db+carry;
			re[len] = carry%2;
			carry /= 2;
			len--; lenb--;
		}
		
		StringBuilder result = new StringBuilder();
		len = re.length-1;
		while(len >= 0) {
			result.append(re[len]);
			len--;
		}
		if(carry != 0) {
			result.insert(0, carry);
		}
		return result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("111", "1"));
	}

}
