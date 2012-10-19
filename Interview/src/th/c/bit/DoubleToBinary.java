package th.c.bit;

public class DoubleToBinary {

	public static String printBinary(double num) {
		if(num >= 1 || num <= 0) return "ERROR";
		StringBuilder result = new StringBuilder();
		result.append("0.");
		while(num > 0) {
			if(result.length() > 32) return "ERROR";
			double r = num * 2;
			if(r >= 1) {
				result.append("1");
				num = r - 1;
			} else {
				result.append("0");
				num = r;
			}
		}
		return result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
