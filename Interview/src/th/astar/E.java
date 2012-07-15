package th.astar;

import java.util.*;

public class E {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String name = cin.next();
		if(!(name.charAt(0) >= 'a' && name.charAt(0) <= 'z') || name.charAt(name.length()-1) == '_') {
			System.out.println("Error!");
		} else {
			int style = 0; //1 c++ 0 java
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				if(style == 1 ) {
					if(c == '_'){
						if(name.charAt(i-1) == '_') {
							System.out.println("Error!");
							return;
						}
					}else if(!(c >= 'a' && c <= 'z')) {
						System.out.println("Error!");
						return;
					}else if(name.charAt(i-1) == '_') {
						sb.append((char)(c-32));
					} else {
						sb.append(c);
					}
				} else if(style == 2){
					if(c == '_') {
						System.out.println("Error!");
						return;
					}
					if(c >= 'A' && c <= 'Z') {
						sb.append("_");
						sb.append((char)(c+32));
					} else if(c >= 'a' && c <= 'z'){
						sb.append(c);
					} else {
						System.out.println("Error!");
						return;
					}
				} else {
					if(c == '_') {
						style = 1;
					} else if(c >= 'A' && c <= 'Z') {
						style = 2;
						sb.append("_");
						sb.append((char)(c+32));
					} else if(c >= 'a' && c <= 'z'){
						sb.append(c);
					} else {
						System.out.println("Error!");
						return;
					}
				}
			}
			System.out.println(sb.toString());
		}
	}

}
