package treelibrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
/**
 * Rappresenta un albero generico di cui non si conosce il loro tipo di nodi.
 *
 * @param <V> Tipo di oggetto all'interno dell'albero
 * @param <N> Tipo del nodo
 */
public abstract class Tree<V, N extends BinaryNode<V, N>> implements Iterable<V> {

    private enum Direction {
	LEFT, RIGHT;
    }

    protected int size = 0;
    protected N root = null;
    
    /**
     * Permette di comparare i nodi tra loro.
     */
    protected Comparator<V> comparator;

    public Tree(Comparator<V> comp) {
	this.comparator = comp;
    }

    protected N getNode(V val, N punt) {
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

    protected V get(V value, N punt) {
	N nodo = getNode(value, punt);

	return (nodo != null) ? nodo.value() : null;
    }

    @Override
    public Iterator<V> iterator() {
	return new Iterator<V>() {
		public Iterator<N> it = new Iterator<N>() {
			public N punt = root;
			public N begin = root;
			public ArrayList<Direction> direction = new ArrayList<>();

			@Override
			public boolean hasNext() {
			    return punt != null;
			}

			@Override
			public N next() {
			    N p = this.punt;

			    if (this.punt.left() != null) {
				this.direction.add(0, Direction.LEFT);
				this.punt = this.punt.left();
			    } else if (this.punt.right() != null) {
				this.direction.add(0, Direction.RIGHT);
				this.punt = this.punt.right();
			    } else {
				top();
				if (this.punt == this.begin)
				    this.punt = null;
			    }

			    return p;
			}

			private void top() {
			    while (direction.size() != 0) {
				Direction dir = direction.remove(0);
				this.punt = this.punt.father();
				if (dir == Direction.LEFT && this.punt.right() != null) {
				    this.direction.add(0, Direction.RIGHT);
				    this.punt = this.punt.right();
				    break;
				}
			    }
			}

		    };

		@Override
		public boolean hasNext() {
		    return it.hasNext();
		}

		@Override
		public V next() {
		    return it.next().value();
		}

	    };
    }
/**
 * Inserisce un oggetto di tipo V all'interno dell'albero
 * @param val oggetto da inserire nell'albero.
 * @return Il nodo che esisteva precedentemente<br> null altrimenti
 */
    public abstract V put(V val);

    public int size() {
	return this.size;
    }

    public V remove(V value) {
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

    protected N leaveFather(N node) {
	return leaveFather(node, null);
    }

    protected N leaveFather(N node, N child) {
	N father = node.father();
	if (father != null)
	    if (father.left() == node)
		father.setLeft(child);
	    else
		father.setRight(child);
	return father;
    }

    public boolean isEmpty() {
	return this.root == null;
    }
}
