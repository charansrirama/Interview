package amazon.leetcode;

public class BigNumber {

	public String add(String a, String b) {
		String result = "";
		a = a.trim();
		b = b.trim();
		
		int lenA = a.length();
		int lenB = b.length();
		int smallerLen = (lenA > lenB) ? lenB : lenA;
		
		int remainder = 0;
		for(int i = smallerLen-1; i >= 0; i--) {
			int bitOfA = a.charAt(i) - '0';
			int bitOfB = b.charAt(i) - '0';
			result = (bitOfA + bitOfB + remainder)%10 + result;
			remainder = (bitOfA + bitOfB + remainder)/10;
		}
		
		if((lenB - smallerLen) != 0) {
			for(int i = lenB - smallerLen-1; i >= 0; i--) {
				int bitOfB = b.charAt(i) - '0';
				result = (bitOfB + remainder)%10 + result;
				remainder = (bitOfB + remainder)/10;
			}
		} else if((lenA - smallerLen) != 0){
			for(int i = lenA - smallerLen-1; i >= 0; i--) {
				int bitOfA = a.charAt(i) - '0';
				result = (bitOfA + remainder)%10 +result;
				remainder = (bitOfA + remainder)/10;
			}
		}
		
		if(remainder != 0) {
			result = remainder + result;
		}
		
		return result;
	}
	
	public String minus(String f, String s) {
        // 将字符串翻转并转换成字符数组  
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();  
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();  
        int lenA = a.length;  
        int lenB = b.length;  
        // 找到最大长度  
        int len = lenA > lenB ? lenA : lenB;  
        int[] result = new int[len];  
        // 表示结果的正负  
        char sign = '+';  
        // 判断最终结果的正负  
        if (lenA < lenB) {  
            sign = '-';  
        } else if (lenA == lenB) {  
            int i = lenA - 1;  
            while (i > 0 && a[i] == b[i]) {  
                i--;  
            }  
            if (a[i] < b[i]) {  
                sign = '-';  
            }  
        }  
        // 计算结果集，如果最终结果为正，那么就a-b否则的话就b-a  
        for (int i = 0; i < len; i++) {  
            int aint = i < lenA ? (a[i] - '0') : 0;  
            int bint = i < lenB ? (b[i] - '0') : 0;  
            if (sign == '+') {  
                result[i] = aint - bint;  
            } else {  
                result[i] = bint - aint;  
            }  
        }  
        // 如果结果集合中的某一位小于零，那么就向前一位借一，然后将本位加上10。其实就相当于借位做减法  
        for (int i = 0; i < result.length - 1; i++) {  
            if (result[i] < 0) {  
                result[i + 1] -= 1;  
                result[i] += 10;  
            }  
        }  
  
        StringBuffer sb = new StringBuffer();  
        // 如果最终结果为负值，就将负号放在最前面，正号则不需要  
        if (sign == '-') {  
            sb.append('-');  
        }  
        // 判断是否有前置0  
        boolean flag = true;  
        for (int i = len - 1; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            } else {  
                flag = false;  
            }  
            sb.append(result[i]);  
        }  
        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0  
        if (sb.toString().equals("")) {  
            sb.append("0");  
        }  
        // 返回值  
        System.out.println(sb.toString());  
        return sb.toString();
	}
	
	public String multipy(String a, String b) {
		a = a.trim(); 
		b = b.trim();
		if(a.equals("0") || b.equals("0")) 
			return "0";
		boolean minus = false;
		if(a.charAt(0) == '-') {
			minus = !minus;
			a = a.substring(1);
		}
		if(b.charAt(0) == '-') {
			minus = !minus;
			b = b.substring(1);
		}
		
		int result[] = new int[a.length() + b.length()];
		
		for(int i = 0; i < a.length(); i++) {
			int da = a.charAt(a.length() - i - 1) - '0';
			int carry = 0;
			for(int j = 0; j < b.length(); j++) {
				int db = b.charAt(b.length() - j - 1) - '0';
				carry = da*db + result[i+j] + carry;
				result[i+j] = carry%10;
				carry = carry/10;
			}
			result[i + b.length()] = carry;
		}

		StringBuilder resultString = new StringBuilder();
		int i = result.length-1;
		for(; i >= 0; i--) {
			if(result[i] != 0)
				break;
		}
		
		for(; i >= 0; i--) {
			resultString.append(result[i]);
		}
		if(minus) {
			resultString.insert(0, "-");
		}
		
		return resultString.toString();
	}
	
	public String divide(String a, String b) {
		return "";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigNumber big = new BigNumber();
		System.out.println(big.multipy("11", "11"));
	}

}
