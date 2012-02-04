package th.other;

public class Bigger {

    // 不用比较运算符，判断int型的a，b两数的大小
    /**
     * @param args
     */
    public static void main(String[] args) {
	int a = -2147483648;
	int b = 2147483647;

	String[] strArray = { "a>=b", "a<b" };

	int i = (int) ((long) a - (long) b >>> 63);
	System.out.println(strArray[i]);
    }

}
