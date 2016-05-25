package dimN;

public class Node<V> {
    private V value;

    public Node(V val) {
	setValue(val);
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

    @Override
    public String toString() {
	return value.toString();
    }
}
