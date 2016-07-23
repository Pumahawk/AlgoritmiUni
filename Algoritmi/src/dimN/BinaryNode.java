package dimN;

public abstract class BinaryNode<V, P extends BinaryNode<V, P>> {
    private V value;
    private P father;
    private P left;
    private P right;

    public BinaryNode(V val, P father, P left, P right) {
	this.value = val;
	this.father = father;
	this.left = left;
	this.right = right;
    }

    public BinaryNode(V val) {
	this(val, null, null, null);
    }

    public BinaryNode() {
	this(null);
    }

    public V value() {
	return this.value;
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

    public void setValue(V value) {
	this.value = value;
    }

    public void setFather(P father) {
	this.father = father;
    }

    public void setLeft(P left) {
	this.left = left;
    }

    public void setRight(P right) {
	this.right = right;
    }

}
