package dimN;

public class BinaryNode<C, P extends Node<C>> extends Node<C> {

    private P left;
    private P right;

    public BinaryNode(C val, P left, P right) {
	super(val);
	setLeft(left);
	setRight(right);
    }

    public BinaryNode(C val) {
	super(val);
	setLeft(null);
	setRight(null);
    }

    public BinaryNode() {
	super();
	setLeft(left);
	setRight(right);
    }

    public P left() {
	return this.left;
    }

    public P right() {
	return this.right;
    }

    public void setLeft(P left) {
	this.left = left;
    }

    public void setRight(P right) {
	this.right = right;
    }

}
