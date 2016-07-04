package dimN;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @param <V>
 * @param <N>
 */
public abstract class Tree<V, N extends BinaryNode<V, N>> implements Iterable<V> {

    private enum Direction {
	LEFT, RIGHT;
    }

    private class IterImpl implements Iterator<N> {
	public N punt;
	public N begin;
	public List<Direction> direction;

	/**
	 * @param punt
	 */
	public IterImpl(N punt) {
	    this.punt = punt;
	    this.begin = punt;
	    this.direction = new List<>();

	}

	@Override
	public boolean hasNext() {
	    return punt != null;
	}

	@Override
	public N next() {
	    N p = this.punt;

	    if (this.punt.left() != null) {
		this.direction.put(Direction.LEFT);
		this.punt = this.punt.left();
	    } else if (this.punt.right() != null) {
		this.direction.put(Direction.RIGHT);
		this.punt = this.punt.right();
	    } else {
		top();
		if (this.punt == this.begin)
		    this.punt = null;
	    }

	    return p;
	}

	private void top() {
	    while (direction.hasNext()) {
		Direction dir = direction.pop();
		this.punt = this.punt.father();
		if (dir == Direction.LEFT && this.punt.right() != null) {
		    this.direction.put(Direction.RIGHT);
		    this.punt = this.punt.right();
		    break;
		}
	    }
	}

    }

    private class VIterImpl implements Iterator<V> {
	public Iterator<N> it;

	/**
	 * @param root
	 */
	public VIterImpl(N root) {
	    it = new IterImpl(root);
	}

	@Override
	public boolean hasNext() {
	    return it.hasNext();
	}

	@Override
	public V next() {
	    return it.next().value();
	}

    }

    protected int size = 0;
    protected N root = null;
    protected Comparator<V> comparator;

    /**
     * @param comp
     */
    public Tree(Comparator<V> comp) {
	this.comparator = comp;
    }

    /**
     * @param val
     * @param punt
     * @return
     */
    protected N getNode(V val, N punt) {
	if (punt != null)
	    return (comparator.compare(punt.value(), val) == 0) ? punt
		    : (comparator.compare(val, punt.value()) < 0) ? getNode(val, punt.left())
			    : getNode(val, punt.right());
	else
	    return null;
    }

    /**
     * @param comparator
     */
    public void setComparator(Comparator<V> comparator) {
	this.comparator = comparator;
    }

    /**
     * @param arg0
     * @return a value
     */
    public V get(V arg0) {
	return get(arg0, root);
    }

    protected V get(V value, N punt) {
	N nodo = getNode(value, punt);

	return (nodo != null) ? nodo.value() : null;
    }

    @Override
    public Iterator<V> iterator() {
	return new VIterImpl(root);
    }

    /**
     * @param val
     */
    public abstract V put(V val);

    /**
     * @return the size
     */
    public int size() {
	return this.size;
    }

    /**
     * @param value
     * @return the deleted value
     */
    protected V remove(V value) {
	V ret = null;
	N node = getNode(value, root);
	if (node != null) {
	    ret = node.value();
	    if (node.left() == null)
		if (node == root)
		    root = root.right();
		else
		    leaveFather(node, node.right());
	    else if (node.right() == null)
		if (node == root)
		    root = root.left();
		else
		    leaveFather(node, root.left());
	    else {
		N minOfMax = findMinOfMax(node);
		if (minOfMax == node)
		    if (node == root)
			root = null;
		    else
			leaveFather(node);
		else {
		    node.setValue(minOfMax.value());
		    if (minOfMax.left() != null)
			leaveFather(minOfMax, minOfMax.left());
		    else
			leaveFather(minOfMax, minOfMax.right());
		}
	    }
	    this.size--;
	}
	return ret;
    }

    /**
     * @param node
     * @return the node
     */
    protected N findMinOfMax(N node) {
	N ret = node;
	if (ret.right() != null) {
	    ret = ret.right();
	    while (ret.left() != null)
		ret = ret.left();
	} else if (ret.left() != null)
	    ret = ret.left();
	return ret;

    }

    /**
     * @param node
     * @return the value of the removed value
     */
    protected V removeNode(N node) {
	if (node != null) {
	    N myNode = getNode(node.value(), this.root);
	    if (myNode != null) {
		if (leaveFather(myNode) != null) {
		    putNode(myNode.left());
		    putNode(myNode.right());
		} else if (myNode.right() != null) {
		    this.root = myNode.right();
		    putNode(myNode.left());
		} else
		    this.root = myNode.left();
		return myNode.value();
	    } else
		return null;
	} else
	    return null;
    }

    /**
     * @param node
     * @return a node
     */
    protected N leaveFather(N node) {
	return leaveFather(node, null);
    }

    /**
     * @param node
     * @param child
     * @return a node
     */
    protected N leaveFather(N node, N child) {
	N father = node.father();
	if (father != null)
	    if (father.left() == node)
		father.setLeft(child);
	    else
		father.setRight(child);
	return father;
    }

    /**
     * @param node
     */
    protected void putNode(N node) {
	if (node != null)
	    if (this.root != null)
		putNode(node, this.root);
	    else
		this.root = node;
    }

    /**
     * @param node
     * @param root
     */
    protected void putNode(N node, N root) {
	if (comparator.compare(node.value(), root.value()) < 0)
	    if (root.left() != null)
		putNode(node, root.left());
	    else
		root.setLeft(node);
	else if (root.right() != null)
	    putNode(node, root.right());
	else
	    root.setRight(node);

    }

    /**
     * @return true if root is null, else false
     */
    public boolean isEmpty() {
	return this.root == null;
    }
}
