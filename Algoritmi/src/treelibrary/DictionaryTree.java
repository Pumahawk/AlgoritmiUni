package treelibrary;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;

abstract class DictionaryTree<K, V, T extends Tree<ContainerDictionary<K, V>, ?>> extends Dictionary<K, V> {

    protected T tree;

    private class KEnum implements Enumeration<K> {

	public Iterator<ContainerDictionary<K, V>> it;

	public KEnum(T tr) {
	    it = tr.iterator();
	}

	@Override
	public K nextElement() {
	    return it.next().key;
	}

	@Override
	public boolean hasMoreElements() {
	    return it.hasNext();
	}

    }

    private class VEnum implements Enumeration<V> {

	public Iterator<ContainerDictionary<K, V>> it;

	public VEnum(T tr) {
	    it = tr.iterator();
	}

	@Override
	public V nextElement() {
	    return it.next().value;
	}

	@Override
	public boolean hasMoreElements() {
	    return it.hasNext();
	}

    }

    public DictionaryTree(Comparator<K> comp) {
	this.tree = instanceTree(comp);
    }

    protected abstract T instanceTree(Comparator<K> comp);

    @Override
    public Enumeration<V> elements() {
	return new VEnum(tree);
    }

    @Override
    public Enumeration<K> keys() {
	return new KEnum(tree);
    }

    @Override
    public V get(Object arg0) {
	ContainerDictionary<K, V> c = tree.get(new ContainerDictionary<K, V>((K) arg0, null));
	return (c != null) ? c.value : null;
    }

    @Override
    public boolean isEmpty() {
	return tree.isEmpty();
    }

    @Override
    public V put(K key, V val) {
	ContainerDictionary<K, V> ret = tree.put(new ContainerDictionary<K, V>(key, val));
	return (ret != null) ? ret.value : null;

    }

    @Override
    public V remove(Object key) {
	ContainerDictionary<K, V> cont = null;
	cont = tree.remove(new ContainerDictionary<K, V>((K) key, null));
	if (cont != null)
	    return cont.value;
	else
	    return null;
    }

    @Override
    public int size() {
	return this.tree.size();
    }
}
