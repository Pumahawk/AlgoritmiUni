package dimN;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
    private class PersonalNode extends NodeList<T, PersonalNode> {
	public PersonalNode(T val) {
	    this(val, null);
	}

	public PersonalNode(T val, PersonalNode next) {
	    super(val, next);
	}
    }

    private class IteratorList implements Iterator<T> {
	public PersonalNode node;

	public IteratorList(PersonalNode node) {
	    this.node = node;
	}

	@Override
	public boolean hasNext() {
	    return node != null;
	}

	@Override
	public T next() {
	    T val = node.value();
	    node = node.next();
	    return val;
	}

    }

    private int size;
    private PersonalNode head;

    @Override
    public Iterator<T> iterator() {
	return new IteratorList(head);
    }

    public void put(T val) {
	PersonalNode next = head;
	head = new PersonalNode(val, next);
    }

    public T pop() {
	T ret = head.value();
	head = head.next();
	return ret;
    }

    public boolean next() {
	return head != null;
    }

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
