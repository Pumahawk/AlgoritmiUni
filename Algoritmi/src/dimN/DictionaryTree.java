package dimN;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;

public abstract class DictionaryTree<K, V, T extends Tree<ContainerDictionary<K, V>, ?>> extends Dictionary<K, V> {

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

    @Override
    public Enumeration<V> elements() {
	return new VEnum(tree);
    }

    @Override
    public Enumeration<K> keys() {
	return new KEnum(tree);
    }
}
