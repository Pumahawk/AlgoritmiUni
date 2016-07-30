package treelibrary;

class NodeNormalTree<V> extends BinaryNode<V, NodeNormalTree<V>> {

    public NodeNormalTree(V val, NodeNormalTree<V> father, NodeNormalTree<V> left, NodeNormalTree<V> right) {
	super(val, father, left, right);
    }

    public NodeNormalTree(V val) {
	super(val);
    }

    public NodeNormalTree() {
	super();
    }
}
