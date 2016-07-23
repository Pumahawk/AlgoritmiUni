package dimN;

import java.util.Comparator;

public class NormalTree<V> extends Tree<V, NormalTreeNode<V>> {

    public NormalTree(Comparator<V> comp) {
	super(comp);
    }

    @Override
    public V put(V val) {
	if (root == null) {
	    root = new NormalTreeNode<V>(val, null, null, null);
	    return null;
	} else
	    return put(val, root);
    }

    private V put(V val, NormalTreeNode<V> node) {
	// node != null
	if (comparator.compare(val, node.value()) == 0) {
	    V ret = node.value();
	    node.setValue(val);
	    return ret;
	} else if (comparator.compare(val, node.value()) < 0) {
	    if (node.left() == null) {
		node.setLeft(new NormalTreeNode<V>(val, node, null, null));
		return null;
	    } else {
		return put(val, node.left());
	    }
	} else {
	    if (node.right() == null) {
		node.setRight(new NormalTreeNode<V>(val, node, null, null));
		return null;
	    } else {
		return put(val, node.right());
	    }
	}
    }
}
