package dimN;

public class BinaryNode<C, P extends Node<C>> extends Node<C> {

    private P father;
    private P left;
    private P right;

    public BinaryNode(C val, P father, P left, P right) {
	super(val);
	setFather(father);
	setLeft(left);
	setRight(right);
    }

    public BinaryNode(C val) {
	this(val, null, null, null);
    }

    public BinaryNode() {
	this(null, null, null, null);
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
