package dimN;

class StaticBinaryNode<V> extends BinaryNode<V, StaticBinaryNode<V>> {

    /**
     * @param val
     * @param father
     * @param left
     * @param right
     */
    public StaticBinaryNode(V val, StaticBinaryNode<V> father, StaticBinaryNode<V> left, StaticBinaryNode<V> right) {
	super(val, father, left, right);
    }

    /**
     * @param val
     */
    public StaticBinaryNode(V val) {
	this(val, null, null, null);
    }
}
