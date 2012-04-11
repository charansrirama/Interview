package th.hard;

public class PickRandomly {

	public static int rand(int lower, int higher) {
		return lower + (int) (Math.random() * (higher - lower + 1));
	}

	public static int[] pickRandomly(int[] orignial, int m) {
		int[] subset = new int[m];
		int[] array = orignial.clone();
		for (int j = 0; j < m; j++) {
			int index = rand(j, array.length);
			subset[j] = array[index];
			array[index] = array[j];
		}

		return subset;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cards[] = new int[52];

		for (int i = 0; i < 52; i++) {
			cards[i] = i + 1;
		}
		
		int subset[] = pickRandomly(cards, 10);
		
		th.util.Printer.arrayPrinter(subset);
		
	}
	
}
