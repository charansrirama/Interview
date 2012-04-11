package th.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import th.util.*;

public class ThreeSum {

	public static ArrayList<ArrayList<Integer>> simple3Sum(int array[]) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Sort.quickSort(array);
		Printer.arrayPrinter(array);
		for (int i = array.length - 1; i > 1; i--) {
			int k = 0;
			int j = i-1;
			while(k < j) {
				//System.out.println(array[i] + " + " + array[j] + " + " + array[k]);
				
				if(array[i] + array[j] + array[k] < 0) {
					k++;
				}
				else if(array[i] + array[j] + array[k] > 0)
					j--;
				else {
					//System.out.println("Find!");
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(array[j]);
					temp.add(array[k]);
					temp.add(array[i]);
					result.add(temp);
					k++;
					while(array[k] == array[k-1]) k++;
				}
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException, URISyntaxException {
		//int array[] = new int[] { 8, 9, 3, 2, 5, 10, 11 };
		URL url = new URL("http://www.cs.princeton.edu/introcs/41analysis/1Kints.txt");
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		int number = Integer.parseInt(br.readLine());
		int array[] = new int[number];
		String line;
		int i = 0;
		while((line = br.readLine())!=null) {
			array[i++] = Integer.parseInt(line);
		}
		//Printer.arrayPrinter(array);
//		int array1[] = new int[] { -1, 0, 1, 2, -1, -4};
		int array1[] = new int[] { 30, -30, -20, -10, 40, 0, 10, 15};
		ArrayList<ArrayList<Integer>> result = simple3Sum(array1);
		for(ArrayList<Integer> set :result) {
			for(Integer ii : set) {
				System.out.print(ii + " ");
			}
			System.out.println();
		}
	}

}
