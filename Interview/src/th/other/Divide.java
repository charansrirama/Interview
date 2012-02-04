package th.other;

import javax.swing.JOptionPane;

public class Divide {

    public static int divide(int dividend, int divisor) {
	int i = 0;
	while (dividend >= divisor) {
	    dividend -= divisor;
	    i++;
	}

	return i;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	JOptionPane.showMessageDialog(null, divide(5, 2));
    }

}
