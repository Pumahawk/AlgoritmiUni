package dimN;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<T> implements Iterable<T> {

    private class PNode extends NodeList<T, PNode> {

	/**
	 * @param val
	 */
	public PNode(T val) {
	    this(val, null);
	}

	/**
	 * @param val
	 * @param next
	 */
	public PNode(T val, PNode next) {
	    super(val, next);
	}
    }

    private class IteratorList implements Iterator<T> {
	public PNode node;

	/**
	 * @param node
	 */
	public IteratorList(PNode node) {
	    this.node = node;
	}

	@Override
	public boolean hasNext() {
	    return node != null;
	}

	@Override
	public T next() {
	    if (!hasNext())
		throw new NoSuchElementException();
	    else {
		T val = node.value();
		node = node.next();
		return val;
	    }
	}

    }

    private int size;
    private PNode head;

    @Override
    public Iterator<T> iterator() {
	return new IteratorList(head);
    }

    /**
     * @param val
     */
    public void put(T val) {
	head = new PNode(val, head);
	this.size++;
    }

    public T pop() {
	T ret = head.value();
	head = head.next();
	this.size--;
	return ret;
    }

    public boolean hasNext() {
	return head != null;
    }

    public int size() {
	return size;
    }

    /**
     * @param args
     */
    public static void main(String args[]) {
	List<String> list = new List<>();
	list.put("1");
	list.put("2");
	list.put("3");

	for (String par : list)
	    System.out.println(par);

	return;
    }

}
