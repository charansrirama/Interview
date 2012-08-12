package th.pocket.gems;

public class Hanoi {

	public static void movePan(int pan, String source, String target) {
		System.out.println("Move: " + pan + " from " + source + " to " + target);
	}
	
	public static void hanoi(int pan, String source, String target, String tmp) {
		if(pan == 1) {
			movePan(1, source, target);
		} else {
			hanoi(pan-1, source, tmp, target);
			movePan(pan, source, target);
			hanoi(pan-1, tmp, target, source);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(3, "1", "3", "2");
	}

}
