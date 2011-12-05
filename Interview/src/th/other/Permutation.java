package th.other;

import java.util.*;

public class Permutation {
    
//    private String[] b = {"1","2","2","3","4","5"};
    private String[] b = {"a","a","b","b","c","c"};
    int n = b.length;
    
    private String result = "";
    
    private boolean[] visit = new boolean[n];
    
    private int[][] graph = new int[n][n];
    
    private Set<String> set = new TreeSet<String>();
    
    private int count;
    
    private void start() {
	for(int i = 0; i < n; i++) {
	    for(int j = 0; j < n; j++) {
		if(i == j)
		    graph[i][j] = 0;
		else 
		    graph[i][j] = 1;
	    }
	}
	
	//graph[3][5] = 0; graph[5][3] = 0;
	
	for(int i = 0; i < n; i++) {
	    this.sort(i);
	   //System.out.println("=====");
	}

	System.out.println("所有排列如下：");
	for (String s : set) {
	    System.out.println(s);
	}
    }
    
    private void sort(int startIndex) {
	result = result + b[startIndex];
	//System.out.println(result);
	
	visit[startIndex] = true;
	
	if(result.length() == n) {
	    set.add(result);
	    count++;
//	    if(result.indexOf("4")!=2) {
//		set.add(result);
//		count++;
//	    }
	}
	
	for(int i = 0; i < n; i++)
	    if(graph[startIndex][i] == 1 && visit[i]== false)
		sort(i);
	
	result = result.substring(0, result.length()-1);
	visit[startIndex] = false;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	new Permutation().start();
    }

}
