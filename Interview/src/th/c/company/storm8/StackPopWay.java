package th.c.company.storm8;

import java.util.*;

public class StackPopWay {
	
	public static ArrayList<ArrayList<Integer>> stackPopWay(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(A == null || A.size() == 0) return results;
		help(A, new Stack<Integer>(), new ArrayList<Integer>(), results);
		return results;
	}
	
	public static void help(ArrayList<Integer> A, Stack<Integer> s, ArrayList<Integer> t, ArrayList<ArrayList<Integer>> results) {
		Stack<Integer> tmp = (Stack<Integer>) s.clone();
		ArrayList<Integer> cA = new ArrayList<Integer>(A);
		int n = cA.get(0);
		cA.remove(0);
		tmp.push(n);
		if(cA.size() == 0) {
			ArrayList<Integer> re = new ArrayList<Integer>(t);
			while(!tmp.isEmpty()) re.add(tmp.pop());
			results.add(re);
		} else {
			help(cA, tmp, t, results);
			ArrayList<Integer> re = new ArrayList<Integer>(t);
			while(!tmp.isEmpty()) {
				re.add(tmp.pop());
				help(cA, tmp, re, results);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1); A.add(2); A.add(3);
		ArrayList<ArrayList<Integer>> re = stackPopWay(A);
		for(ArrayList<Integer> r : re) {
			System.out.println(r);
		}
	}

}
