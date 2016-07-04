package dimN;

/**
 * @param <V>
 */
public class Node<V> {
    private V value;

    /**
     * @param val
     */
    public Node(V val) {
	setValue(val);
    }

    public Node() {
	this(null);
    }

    /**
     * @return value
     */
    public V value() {
	return this.value;
    }

    /**
     * @param val
     */
    public void setValue(V val) {
	this.value = val;
    }

    @Override
    public String toString() {
	return value.toString();
    }
}
