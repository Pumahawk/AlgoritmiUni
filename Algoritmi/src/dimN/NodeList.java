package dimN;

/**
 * @param <V>
 * @param <P>
 */
public class NodeList<V, P extends Node<V>> extends Node<V> {
    private P next;

    /**
     * @param cont
     * @param next
     */
    public NodeList(V cont, P next) {
	super(cont);
	setNext(next);
    }

    /**
     * @param cont
     */
    public NodeList(V cont) {
	this(cont, null);
    }

    public NodeList() {
	this(null);
    }

    /**
     * @return the next
     */
    public P next() {
	return this.next;
    }

    /**
     * @param next
     */
    public void setNext(P next) {
	this.next = next;
    }
}
