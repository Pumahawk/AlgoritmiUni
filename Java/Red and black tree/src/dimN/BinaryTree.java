package dimN;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

public class BinaryTree<K, V> extends Dictionary<K, V> {
    public enum Direction {
	NORTH, EAST, WEST;
    }

    private class Content {
	public K key;
	public V value;
    }

    private class Enum implements Enumeration<V> {
	public BinaryNode<Content, ?> punt;
	public Direction direction;

	@Override
	public boolean hasMoreElements() {
	    return punt != null;
	}

	@Override
	public V nextElement() {
	    return null;
	}

    }

    protected int size = 0;
    protected BinaryNode<Content, ?> root = null;
    protected Comparator<K> comparator;

    public BinaryTree(Comparator<K> comp) {
	this.comparator = comp;
    }

    public BinaryTree(Dictionary<K, V> dictionary, Comparator<K> comp) {
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();)
	    this.put(key = keys.nextElement(), dictionary.get(key));
	this.size = dictionary.size();
    }

    @Override
    public Enumeration<V> elements() {
	return null;
    }

    @Override
    public V get(Object arg0) {
	return get(arg0, root);
    }

    public V get(Object key, BinaryNode<Content, ?> punt) {
	if (punt != null)
	    return (comparator.compare(punt.value().key, (K) key) == 0) ? punt.value().value
		    : (comparator.compare(punt.value().key, (K) key) < 0)
			    ? get(key, (BinaryNode<BinaryTree<K, V>.Content, ?>) punt.left())
			    : get(key, (BinaryNode<BinaryTree<K, V>.Content, ?>) punt.right());
	else
	    return null;
    }

    @Override
    public boolean isEmpty() {
	return this.root == null;
    }

    @Override
    public Enumeration<K> keys() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public V put(K arg0, V arg1) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public V remove(Object arg0) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int size() {
	return size;
    }

    public static void main(String args[]) {
    }

}
