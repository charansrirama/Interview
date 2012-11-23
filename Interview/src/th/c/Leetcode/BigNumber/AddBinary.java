package th.c.Leetcode.BigNumber;

public class AddBinary {
//Shorter version
	public String addBinary2(String a, String b) {
        if(a == null) return b;
        if(b == null) return a;
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int carry = 0;
        int ia = ac.length-1, ib = bc.length-1;
        StringBuilder buffer = new StringBuilder();
        while(ia >= 0 || ib >= 0) {
            int ta = ia >= 0 ? ac[ia]-'0' : Integer.MIN_VALUE;
            int tb = ib >= 0 ? bc[ib]-'0' : Integer.MIN_VALUE;
            if(ta == Integer.MIN_VALUE) {
                buffer.append((tb+carry)%2);
                carry = (tb+carry)/2;
                ib--;
            } else if(tb == Integer.MIN_VALUE) {
                buffer.append((ta+carry)%2);
                carry = (ta+carry)/2;
                ia--;
            } else {
                buffer.append((ta+tb+carry)%2);
                carry = (ta+tb+carry)/2;
                ia--; ib--;
            }
        }
        if(carry != 0) buffer.append(carry);
        return buffer.reverse().toString();
    }
	
	public static String addBinary(String a, String b) {
		if(a == null || a.length() == 0) return b;
		if(b == null || b.length() == 0) return a;
		int ia = a.length()-1, ib = b.length()-1;
		StringBuilder buffer = new StringBuilder();
		int carry = 0;
		while(ia >= 0 && ib >= 0) {
			int ta = a.charAt(ia) - '0';
			int tb = b.charAt(ib) - '0';
			buffer.append((ta+tb+carry)%2);
			carry = (ta+tb+carry)/2;
			ia--; ib--;
		}
		while(ia >= 0) {
			int ta = a.charAt(ia) - '0';
			buffer.append((ta+carry)%2);
			carry = (ta+carry)/2;
			ia--;
		}
		while(ib >= 0) {
			int tb = b.charAt(ib) - '0';
			buffer.append((tb+carry)%2);
			carry = (tb+carry)/2;
			ib--;
		}
		if(carry != 0) buffer.append(carry);
		return buffer.reverse().toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11";
		String b = "10";
		System.out.println(addBinary(a, b));
	}

}
