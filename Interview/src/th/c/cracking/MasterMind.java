package th.c.cracking;

public class MasterMind {
	public int code(char c) {
		switch(c) {
		case 'B': return 0;
		case 'G': return 1;
		case 'R': return 2;
		case 'Y': return 3;
		default: return -1;
		}
	}
	
	public Result estimate(String guess, String solution) throws Exception {
		if(guess.length() != solution.length()) 
			throw new Exception("Wrong input.");
		Result result = new Result();
		int[] frequencies = new int[4];
		for(int i = 0; i < 4; i++) {
			if(guess.charAt(i) == solution.charAt(i)) {
				result.hits++;
			} else {
				int code = code(solution.charAt(i));
				frequencies[code]++;
			}
		}
		for(int i = 0; i < 4; i++) {
			int code = code(guess.charAt(i));
			if(code>=0 && frequencies[code]>0) {
				result.pseudoHits++;
				frequencies[code]--;
			}
		}
		return result;
	}
}

class Result {
	public int hits = 0;
	public int pseudoHits = 0;
	
	public String toString() {
		return "(" + hits + ", " + pseudoHits + ")";
	}
}