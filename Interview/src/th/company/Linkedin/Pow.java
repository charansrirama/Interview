package th.company.Linkedin;

public class Pow {

	public static double pow(double base, int epo) {
		double tmp = base, result = 1.0;
		for(int i = epo; i > 0; i/=2) {
			if(i%2 == 1) result *= tmp;
			tmp = tmp*tmp;
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2, 3));
		System.out.println(pow(2, 2));
	}

}
