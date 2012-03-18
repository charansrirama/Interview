package th.java;

public class ComparableTest implements Comparable<ComparableTest>{
	
	int content;
	
	public ComparableTest(int content) {
		this.content = content;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComparableTest test1 = new ComparableTest(5);
		ComparableTest test2 = new ComparableTest(6);
		
		System.out.println(test1.compareTo(test2));
	}

	@Override
	public int compareTo(ComparableTest arg0) {
		int result = 0;
		if(this.content > arg0.content) {
			result = 1;
		} else if(this.content == arg0.content) {
			result = 0;
		} else if(this.content < arg0.content) {
			result = -1;
		}
		return result;
	}

}
