package th.hard;

public class MinDistance {

	public static int minDistance(String[] file, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int pos1 = -1, pos2 = -1;
		int distance;
		for(int i = 0; i < file.length; i++) {
			if(file[i].equals(word1)) {
				pos1 = i;
				distance = pos1 - pos2;
				if(pos2>=0 && min > distance) {
					min = distance;
				}
			} else if(file[i].equals(word2)){
				pos2 = i;
				distance = pos2 - pos1;
				if(pos1 >= 0 && min > distance) {
					min = distance;
				}
			}
		}
		return min;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] file = "the Tiananmen Square self-immolation incident took place in Tiananmen Square in central Beijing on 23 January 2001. the incident is in disputed: the official Chinese press agency, Xinhua News Agency, stated that five members of Falun Gong, a banned spiritual movement, set themselves on fire to protest the unfair treatment of Falun Gong by the Chinese government.".split(" ");
		for(int i = 0; i < file.length; i++) 
			System.out.println(file[i]);
		
		System.out.println(minDistance(file, "the", "in"));
	}

}
