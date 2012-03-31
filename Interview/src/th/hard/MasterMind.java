package th.hard;

public class MasterMind {

	public static int code(char c) {
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
	
	public static int MAX_COLOR = 4;
	
	public static Result estimate(String guess, String solution) {
		if(guess.length() != solution.length()) return null;
		
		Result res = new Result();
		int frequencies[] = new int[MAX_COLOR];
		
		for(int i = 0; i < solution.length(); i++) {
			if(solution.charAt(i) == guess.charAt(i)) {
				res.hits++;
			} else {
				frequencies[code(solution.charAt(i))]++;
			}
		}
		
		for(int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if(code >= 0 && frequencies[code] >0) {
				res.pseudoHits++;
				frequencies[code]--;
			}
		}
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(estimate("GGRR", "RGBY").toString());
	}

}

class Result{
	public int hits = 0;
	public int pseudoHits = 0;
	
	public String toString() {
		return "(" + hits + ", " + pseudoHits + ")";
	}
}