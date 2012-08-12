package th.pocket.gems;

public class TriangleType {

	public static String triangle(int a, int b, int c) {
		if(a+b <= c || b+c <= a || a+c <= b) {
			return "Not a triangle";
		} else {
			if(a == b || a == c || b == c) {
				if(a==b&&a==c&&b==c) {
					return "Equilateral triangle";
				} else {
					return "Isosceles triangle";
				} 
			} else if(a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a) {
				return "Right triangle";
			} else {
				return "Triangle";
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(triangle(3,4,5));
		System.out.println(triangle(1,1,1));
		System.out.println(triangle(1,2,3));
		System.out.println(triangle(2,2,3));
	}
}
