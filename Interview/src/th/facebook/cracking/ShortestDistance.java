package th.facebook.cracking;

public class ShortestDistance {
	public int shortest(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int lastPos1 = -1, lastPos2 = -1;
		for(int i = 0; i < words.length; i++) {
			String curr = words[i];
			if(curr.equals(word1)) {
				lastPos1 = i;
				int distance = lastPos1-lastPos2;
				if(lastPos2 >= 0 && distance < min)
					min = distance;
			} else if(curr.equals(word2)) {
				lastPos2 = i;
				int distance = lastPos2-lastPos1;
				if(lastPos1>=0 && distance < min) 
					min = distance;
			}
		}
		return min;
	}
}
