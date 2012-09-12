package th.c.TopCoder.srm144;

public class Time {

	public String whatTime(int seconds) {
		StringBuilder result = new StringBuilder();
		result.append(seconds/(60*60)).append(":");
		seconds = seconds%(60*60);
		result.append(seconds/60).append(":");
		result.append(seconds%60);
		return result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
