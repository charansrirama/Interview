package th.hard;

public class Power {
	public static double power(double x, int y) {
		if(y == 0) return 1;
		if(y < 0) return 1.0/power(x, -y);
		
		double dbTemp = power(x, y/2);
		return y%2 == 1 ? dbTemp*dbTemp*x : dbTemp*dbTemp;
	}
	
	public static void main(String[] args) {
		System.out.println(power(2, 3));
	}
}
