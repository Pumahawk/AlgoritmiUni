package dimN;

public class Node<C> {
    private C value;

    public Node(C val) {
	this.value = val;
    }

    public Node() {
	this.value = null;
    }

    public C value() {
	return this.value;
    }

    public void setValue(C val) {
	this.value = val;
    }
}
