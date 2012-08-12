package th.recursion;

public class Hanoi {

	public static void hanoi(int movingPans, String sourcePillar,
			String targetPillar, String tempPillar) {
		if (movingPans == 1) {
			movePans(1, sourcePillar, targetPillar);
		} else {
			hanoi(movingPans - 1, sourcePillar, tempPillar, targetPillar);
			movePans(movingPans, sourcePillar, targetPillar);
			hanoi(movingPans - 1, tempPillar, targetPillar, sourcePillar);
		}
	}

	public static void movePans(int panNum, String sourcePillar,
			String targetPillar) {
		System.out.println("Move " + panNum + " form " + sourcePillar + "# to "
				+ targetPillar + "#");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("3个盘子的汉诺塔问题：");
		hanoi(3, "1", "3", "2");
		System.out.println("5个盘子的汉诺塔问题：");
		hanoi(5, "1", "3", "2");
	}

}
