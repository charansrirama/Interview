package th.other;

public class FloatAndString {

	public static float atof(String val) {
 		float result = 0;
 		int Eindex = 0;
 		boolean neg = false;
 		boolean dotFlag = false;
 		int j = 1;
 		
 		if(val.charAt(0) == '-') {
 			neg = true;
 			val = val.substring(1);
 		}
		for(int i = 0; i < val.length(); i++) {
			if(val.charAt(i) != 'E'){
				if(val.charAt(i) == '.'){
					dotFlag = true;
					continue;
				}
				if(dotFlag) {
					float temp = (float) ((float)(val.charAt(i) - '0') / (Math.pow(10, j++)));
					result = result + temp;
				} else 
					result = result*10 + (val.charAt(i) - '0');
			} else {
				Eindex = i;
				break;
			}
		}
		boolean neg2 = false;
		if(val.charAt(Eindex+1) == '-') {
			neg2 = true;
			Eindex += 2;
		} else {
			Eindex += 1;
		}
		
		int exp = 0;
		for(int i = Eindex; i < val.length(); i++) {
			exp = exp*10 + (val.charAt(i) - '0');
		}
		while(exp > 0) {
			if(neg2) {
				result /= 10;
			} else {
				result *= 10;
			}
			exp--;
		}
		
		if(neg) {
			result *= (-1);
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(atof("-1.033E-3"));
	}

}
