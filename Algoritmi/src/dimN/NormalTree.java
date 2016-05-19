package dimN;

import java.util.Comparator;

public class NormalTree<V> extends Tree<V, StaticBinaryNode<V>> {

    public NormalTree(Comparator<V> comp) {
	super(comp);
    }

    @Override
    public V put(V val) {

	if (this.root == null) {
	    this.root = new StaticBinaryNode<V>(val);
	    this.size++;
	    return null;
	} else
	    return put(val, root);

    }

    private V put(V value, StaticBinaryNode<V> node) {
	if (comparator.compare(value, node.value()) == 0) {
	    V ret = node.value();
	    node.setValue(value);
	    return ret;
	} else if (comparator.compare(value, node.value()) < 0)
	    if (node.left() != null)
		return put(value, node.left());
	    else {
		node.setLeft(new StaticBinaryNode<V>(value, node, null, null));
		this.size++;
		return null;
	    }
	else if (node.right() != null) {
	    return put(value, node.right());
	} else {
	    node.setRight(new StaticBinaryNode<V>(value, node, null, null));
	    this.size++;
	    return null;
	}
    }

}
