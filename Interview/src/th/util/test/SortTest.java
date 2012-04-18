package th.util.test;

public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[ ] data = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0, -1000};
		th.util.Sort.mergesort(data);
		th.util.Printer.arrayPrinter(data);
	}

}
