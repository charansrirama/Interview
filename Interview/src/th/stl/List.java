package th.stl;

/**
 * shijinliang Feb 6, 2012 Interview
 **/
public class List<E> {

    private transient Entry<E> header = new Entry<E>(null);

    public static class Entry<E> {
	E element;
	Entry<E> next;
	Entry<E> previous;

	Entry(E element) {
	    this.element = element;
	}
    }

    public Entry<E> search(E x) {
	if (x == null)
	    return null;
	Entry<E> entry = header;
	while (entry != null && !x.equals(entry.element))
	    entry = entry.next;
	return entry;
    }

    public Entry<E> insert(E x) {
	Entry<E> newEntry = new Entry<E>(x);
	newEntry.next = header;
	if (header != null)
	    header.previous = newEntry;
	header = newEntry;
	newEntry.previous = null;
	return newEntry;
    }

    public void delete(E x) {
	Entry<E> entry = search(x);
	if (entry.previous != null)
	    entry.previous.next = entry.next;
	else
	    header = entry.next;
	if (entry.next != null)
	    entry.next.previous = entry.previous;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	List<Integer> ll = new List<Integer>();
	ll.insert(1);
	ll.insert(2);
	ll.insert(3);
	ll.insert(4);
	ll.delete(3);
	Entry<Integer> e = ll.search(2);
	System.out.println(e.next.element);
	System.out.println(e.previous.element);
    }

}
