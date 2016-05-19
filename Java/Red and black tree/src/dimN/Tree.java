package dimN;

import java.util.Comparator;
import java.util.Iterator;

public abstract class Tree<V, N extends BinaryNode<V, N>> implements Iterable<V> {

    private enum Direction {
	LEFT, RIGHT;
    }

    private class IterImpl implements Iterator<N> {
	public N punt;
	public N begin;
	public List<Direction> direction;

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

    public Tree(Comparator<V> comp) {
	this.comparator = comp;
    }

    public N getNode(V val, N punt) {
	if (punt != null)
	    return (comparator.compare(punt.value(), val) == 0) ? punt
		    : (comparator.compare(val, punt.value()) < 0) ? getNode(val, punt.left())
			    : getNode(val, punt.right());
	else
	    return null;
    }

    public void setComparator(Comparator<V> comparator) {
	this.comparator = comparator;
    }

    public V get(V arg0) {
	return get(arg0, root);
    }

    private V get(V value, N punt) {
	N nodo = getNode(value, punt);

	return (nodo != null) ? nodo.value() : null;
    }

    @Override
    public Iterator<V> iterator() {
	return new VIterImpl(root);
    }

    public abstract V put(V val);

    public int size() {
	return this.size;
    }

    public V remove(N node) {
	if (node != null) {
	    N myNode = getNode(node.value(), this.root);
	    if (myNode != null) {
		if (myNode.father() != null) {
		    if (myNode.father().left() == myNode)
			myNode.father().setLeft(null);
		    else
			myNode.father().setRight(null);
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

    public void putNode(N node) {
	if (node != null)
	    if (this.root != null) {
		if (node != null)
		    putNode(node, this.root);
	    } else {
		this.root.setFather(node);
	    }
    }

    private void putNode(N node, N root) {
	if (comparator.compare(node.value(), root.value()) < 0) {
	    if (root.left() != null) {
		putNode(node, root.left());
	    } else {
		root.setLeft(node);
	    }
	} else {
	    if (root.right() != null) {
		putNode(node, root.right());
	    } else {
		root.setRight(node);
	    }
	}
    }

    public boolean isEmpty() {
	return this == null;
    }
}
