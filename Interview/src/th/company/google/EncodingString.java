package th.company.google;

import java.util.Iterator;

public class EncodingString {
	String str;

	public EncodingString(String s) {
		this.str = s;
	}

	public Iterator iterator() {
		return new EncodingIterator(this.str);
	}

	public static void main(String[] args) {
		EncodingString test = new EncodingString("123456");
		Iterator it = test.iterator();
		while (it.hasNext()) {
			it.next();
		}
		System.out.println("End...");
	}
}

class EncodingIterator implements Iterator {
	String str;
	int current = 0;

	public EncodingIterator(String s) {
		this.str = s;
	}

	@Override
	public boolean hasNext() {
		return current + 2 > str.length() ? false : true;
	}

	@Override
	public Object next() {
		int times = str.charAt(current) - '0';
		int ch = str.charAt(current + 1) - '0';
		for (int i = 0; i < times; i++) {
			System.out.print(ch);
		}
		current += 2;
		if (current == str.length()) {
			System.out.println();
		}
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}

}
