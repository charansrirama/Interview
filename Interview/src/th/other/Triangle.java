package th.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * shijinliang
 * Feb 21, 2012
 * Interview
 **/
public class Triangle {

    public static int whatTriangle(int[] edges) {
	
	// 	
	for(int i = 0; i < edges.length; i++) {
	    for(int j = i; j < edges.length; j++) {
		if(edges[i] > edges[j]) {
		    edges[i] ^= edges[j];
		    edges[j] ^= edges[i];
		    edges[i] ^= edges[j];
		}
	    }
	}
	
	if(edges[0] + edges[1] < edges[2]) {
	    return -1;
	} else if(edges[0] == edges[1] && edges[1] != edges[2]) {
	    return 2;
	} else if(edges[0] == edges[1] && edges[1] == edges[2]) {
	    return 3;
	} else if(edges[0]*edges[0] + edges[1]*edges[1] == edges[2]*edges[2]) {
	    return 4;
	} else 
	    return 1;
    }
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
	System.out.println("Enter three values of edges, EXIT to quit.");
	int edges[] = new int[3];
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = br.readLine();
	while(line!=null) {
	    if(line.equals("EXIT")) {
		break;
	    }
	    String edgesS[] = line.split(" ");
	    for(int i = 0; i < edgesS.length; i++) {
		edges[i] = Integer.parseInt(edgesS[i]);
	    }
	    switch(whatTriangle(edges)) {
	    case -1:
		System.out.println("Not a triangle!");
		break;
	    case 1:
		System.out.println("Triangle!");
		break;
	    case 2:
		System.out.println("Isosceles triangle");
		break;
	    case 3:
		System.out.println("Equilateral triangle");
		break;
	    case 4:
		System.out.println("Retangle triangle");
		break;
	    }
	    line = br.readLine();
	}
    }

}
