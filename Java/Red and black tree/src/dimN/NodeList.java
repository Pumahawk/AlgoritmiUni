package dimN;

public class NodeList<C, P extends Node<C>> extends Node<C> {
    private P next;

    public NodeList(C cont, P next) {
	super(cont);
	this.next = next;
    }

    public NodeList(C cont) {
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
