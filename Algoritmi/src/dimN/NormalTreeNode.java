package dimN;

public class NormalTreeNode<V> extends BinaryNode<V, NormalTreeNode<V>> {

    public NormalTreeNode(V val, NormalTreeNode<V> father, NormalTreeNode<V> left, NormalTreeNode<V> right) {
	super(val, father, left, right);
    }

    public NormalTreeNode(V val) {
	super(val);
    }

    public NormalTreeNode() {
	super();
    }
}
