package dimN;

public class NodeList<V, P extends Node<V>> extends Node<V> {
    private P next;

    public NodeList(V cont, P next) {
	super(cont);
	this.next = next;
    }

    public NodeList(V cont) {
	this(cont, null);
    }

    public NodeList() {
	this(null);
    }

    public P next() {
	return this.next;
    }

    public void setNext(P next) {
	this.next = next;
    }
}
