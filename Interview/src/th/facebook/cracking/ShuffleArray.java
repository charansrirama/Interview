package th.facebook.cracking;

public class ShuffleArray {
	public void shuffleArray(int[] cards) {
		int tmp, index;
		for(int i = 0; i < cards.length; i++) {
			index = (int)(Math.random()*(cards.length-i)) + i;
			tmp = cards[i];
			cards[i] = cards[index];
			cards[index] = tmp;
		}
	}
}
