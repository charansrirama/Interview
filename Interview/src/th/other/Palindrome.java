package th.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			BufferedReader object = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter number: ");
			int num = Integer.parseInt(object.readLine());
			int n = num;
			int rev = 0;
			System.out.println("Number: " + num);
			for(int i = 0; i <= num; i++) {
				int r = num%10;
				num = num/10;
				rev = rev*10 + r;
				i = 0;
			}
			System.out.println("After reversing teh number is " + rev);
			if(n == rev) 
				System.out.println("Number is palindrome");
			else
				System.out.println("Number is not palindrome");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
