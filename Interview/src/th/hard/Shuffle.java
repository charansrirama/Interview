package th.hard;

import java.util.Random;

public class Shuffle {

	public static void shuffleArray(int[] cards) {
		int temp, index;
		Random rand = new Random();
		for(int i = 0; i < cards.length; i++) {
			//index = (int) (Math.random()*(cards.length-i)) + i;
			index = rand.nextInt(cards.length - i);
			temp = cards[i];
			cards[i] = cards[index];
			cards[index] = temp;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cards[] = new int[52];
		
		for(int i = 0; i < 52; i++) {
			cards[i] = i+1;
		}
		shuffleArray(cards);
		
		th.util.Printer.arrayPrinter(cards);
	}

}
