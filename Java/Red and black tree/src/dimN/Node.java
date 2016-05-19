package dimN;

public class Node<V> {
    private V value;

    public Node(V val) {
	this.value = val;
    }

    public Node() {
	this(null);
    }

    public V value() {
	return this.value;
    }

    public void setValue(V val) {
	this.value = val;
    }
}
