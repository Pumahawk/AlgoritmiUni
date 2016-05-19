package dimN;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;

public class DictionaryTree<K, V, T extends Tree<ContainerDictionary<K, V>, StaticBinaryNode<ContainerDictionary<K, V>>>>
	extends Dictionary<K, V> {

    private enum Direction {
	LEFT, RIGHT;
    }

    private class KEnum implements Enumeration<K> {

	public Iterator<ContainerDictionary<K, V>> it;

	public KEnum(T tr) {
	    it = tr.iterator();
	}

	public K nextElement() {
	    return it.next().key;
	}

	@Override
	public boolean hasMoreElements() {
	    return it.hasNext();
	}

    }

    private class VEnum implements Enumeration<V> {

	// public EnumNode en;

	public Iterator<ContainerDictionary<K, V>> it;

	public VEnum(T tr) {
	    it = tr.iterator();
	}

	public V nextElement() {
	    return it.next().value;
	}

	@Override
	public boolean hasMoreElements() {
	    return it.hasNext();
	}

    }

    protected T tree;

    public DictionaryTree(T tree) {
	this.tree = tree;
    }

    @Override
    public Enumeration<V> elements() {
	return new VEnum(tree);
    }

    @Override
    public V get(Object arg0) {
	ContainerDictionary<K, V> c = tree.get((ContainerDictionary<K, V>) arg0);
	return (c != null) ? c.value : null;
    }

    @Override
    public boolean isEmpty() {
	return tree.isEmpty();
    }

    @Override
    public Enumeration<K> keys() {
	return new KEnum(tree);
    }

    @Override
    public V put(K key, V val) {
	ContainerDictionary<K, V> ret = tree.put(new ContainerDictionary<K, V>(key, val));
	return (ret != null) ? ret.value : null;

    }

    @Override
    public V remove(Object key) {
	return null;
	// TODO
    }

    private V remove(Object key, StaticBinaryNode<ContainerDictionary<K, V>> node) {
	// TODO
	return null;
    }

    @Override
    public int size() {
	return this.tree.size();
    }

}