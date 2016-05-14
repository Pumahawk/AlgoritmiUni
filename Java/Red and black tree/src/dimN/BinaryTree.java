package dimN;

import java.util.Dictionary;
import java.util.Enumeration;

public class BinaryTree<K, V> extends Dictionary<K, V> {
    private class Content {
	public K key;
	public V value;
    }

    private BinaryNode<Content, ?> root;

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
	// TODO Auto-generated method stub
	return false;
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
