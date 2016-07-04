package dimN;

/**
 * @param <V>
 * @param <P>
 */
public class BinaryNode<V, P extends Node<V>> extends Node<V> {
    private P father;
    private P left;
    private P right;

    /**
     * @param val
     * @param father
     * @param left
     * @param right
     */
    public BinaryNode(V val, P father, P left, P right) {
	super(val);
	setFather(father);
	setLeft(left);
	setRight(right);
    }

    /**
     * @param val
     */
    public BinaryNode(V val) {
	this(val, null, null, null);
    }

    public BinaryNode() {
	this(null);
    }

    public P father() {
	return this.father;
    }

    public P left() {
	return this.left;
    }

    public P right() {
	return this.right;
    }

    /**
     * @param father
     */
    public void setFather(P father) {
	this.father = father;
    }

    /**
     * @param left
     */
    public void setLeft(P left) {
	this.left = left;
    }

    /**
     * @param right
     */
    public void setRight(P right) {
	this.right = right;
    }

}
