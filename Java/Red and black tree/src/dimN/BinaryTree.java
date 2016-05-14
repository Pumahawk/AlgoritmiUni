package dimN;

import java.util.Dictionary;
import java.util.Enumeration;

public class BinaryTree<K, V> extends Dictionary<K, V> {
    private class Content {
	public K key;
	public V value;
    }

    protected int size = 0;
    protected BinaryNode<Content, ?> root = null;

    public BinaryTree() {
    }

    public BinaryTree(Dictionary<K, V> dictionary) {
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
	// TODO Auto-generated method stub
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
	// TODO Auto-generated method stub
	return 0;
    }

    public static void main(String args[]) {
    }

}
