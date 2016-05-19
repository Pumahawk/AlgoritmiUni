package dimN;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Rappresenta una struttura dinamica in cui l'ultimo dato sara il primo ad
 * essere prelevato.
 * 
 * @author Lorenzo Gandino
 *
 * @param <T>
 *            Tipo di variabile memorizzata nella lista.
 */
public class List<T> implements Iterable<T> {
    /**
     * @author Lorenzo Gandino
     *
     */
    private class PNode extends NodeList<T, PNode> {
	public PNode(T val) {
	    this(val, null);
	}

	public PNode(T val, PNode next) {
	    super(val, next);
	}
    }

    private class IteratorList implements Iterator<T> {
	public PNode node;

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

    public void put(T val) {
	head = new PNode(val, head);
	this.size++;
    }

    // Aggiungere nella documentazione che in caso la lista sia vuota sara
    // lanciato un null'pointer Exception
    public T pop() {
	T ret = head.value();
	head = head.next();
	this.size--;
	return ret;
    }

    public boolean next() {
	return head != null;
    }

    public int size() {
	return size;
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
