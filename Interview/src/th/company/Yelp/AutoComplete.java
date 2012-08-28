package th.company.Yelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AutoComplete {
	
	String[] dictionary;
	String path;
	public AutoComplete(String path) {
		this.dictionary = new String[74047];
		this.path = path;
	}
	
	public void loadDic() {
		Scanner in = null;
		try {
			in = new Scanner(new File(path));
			int count = 0;
			while(in.hasNext()) {
				String line = in.next();
				if(!line.contains("'")) {
					this.dictionary[count++] = line.toLowerCase();
				}
			}
			//System.out.println(count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(in != null) in.close();
		}
	}
	
	public int[] binarySearch(String prefix) {
		int start = 0, end = this.dictionary.length-1;
		while(start <= end) {
			int mid = (start + end) / 2;
			boolean startWith = this.dictionary[mid].startsWith(prefix);
			if(!startWith) {
				int cmp = this.dictionary[mid].compareTo(prefix);
				if(cmp > 0) {
					end = mid -1;
				} else {
					start = mid+1;
				}
			} else { // Found the prefix
				// Find up bound
				int up = mid - 1;
				while(start <= up) {
					int t = (start + up)/2;
					if(this.dictionary[t].startsWith(prefix)) {
						if(t == 0) {
							up = 0;
							break;
						}
						up = t - 1;
					} else {
						start = t + 1;
					}
				}
				up = (this.dictionary[up].startsWith(prefix))? up : up+1;
				// Find low bound
				int down = mid + 1;
				while(down <= end) {
					int t = (down + end)/2;
					if(this.dictionary[t].startsWith(prefix)) {
						down = t + 1;
					} else {
						end = t - 1;
					}
				}
				down = (this.dictionary[down].startsWith(prefix)) ? down : down -1;
				return new int[] {up, down};
			}
		}
		return new int[]{-1,-1};
	}

	public void print(String[] dic, int start, int end) {
		for(int i = start; i <= end; i++) {
			System.out.print(dic[i] + " ");
			if(i % 5 == 0) System.out.println();
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AutoComplete test = new AutoComplete("wordlist.txt");
		test.loadDic();
		Scanner input = new Scanner(System.in);
		String word = "";
		String c;
		while(!(c = input.next()).equals("~")) {
			word += c;
			System.out.println("Input: " + word);
			int[] index = test.binarySearch(word);
			if(index[0] != -1) {
				System.out.println("Suggestion for you: ");
				test.print(test.dictionary, index[0], index[1]);
			} else {
				System.out.println("No suggestion for this input.");
				word = "";
			}
		}
//		System.out.println(test.dictionary[test.dictionary.length-1]);
		int[] index = test.binarySearch("bub");
		System.out.println(index[0] + " " + index[1]);
		//System.out.println(test.dictionary[index[0]] + " " + test.dictionary[index[1]]);
	}

}
