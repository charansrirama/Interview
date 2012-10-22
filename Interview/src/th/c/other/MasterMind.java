package th.c.other;

public class MasterMind {
	
	public static int MAX_COLORS = 4;
	
	private int code(char c) {
		switch(c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}
	
	public Result estimate(String guess, String solution) {
		if(guess == null || solution == null || guess.length() != solution.length()) {
			return null;
		}
		int[] frequencies = new int[MAX_COLORS];
		Result result = new Result();
		for(int i = 0; i < solution.length(); i++) {
			if(guess.charAt(i) == solution.charAt(i)) {
				result.hits++;
			} else {
				int code = code(solution.charAt(i));
				frequencies[code]++;
			}
		}
		for(int i = 0; i < solution.length(); i++) {
			if(guess.charAt(i) != solution.charAt(i)) {
				int code = code(guess.charAt(i));
				if(frequencies[code] > 0) {
					result.pseudoHits++;
					frequencies[code]--;
				}
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Result {
	public int hits = 0;
	public int pseudoHits = 0;
	
	public String toString() {
		return "(" + hits + ", " + pseudoHits + ")";
	}
}
