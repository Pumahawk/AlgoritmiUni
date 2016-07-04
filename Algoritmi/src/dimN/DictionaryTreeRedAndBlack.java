package dimN;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author UMIT AHMED
 *
 * @param <K>
 * @param <V>
 * @param <T>
 */
public abstract class DictionaryTreeRedAndBlack<K, V, T extends Tree<ContainerDictionary<K, V>, ColoredNode<ContainerDictionary<K, V>>>>
	extends Dictionary<K, V> {

    private enum Direction {
	LEFT, RIGHT;
    }

    private class KEnum implements Enumeration<K> {

	public Iterator<ContainerDictionary<K, V>> it;

	/**
	 * @param tr
	 */
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

	// public EnumNode en;

	public Iterator<ContainerDictionary<K, V>> it;

	/**
	 * @param tr
	 */
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

    protected T tree;

    /**
     * @param comp
     */
    public DictionaryTreeRedAndBlack(Comparator<K> comp) {
    }

    /**
     * @param dictionary
     * @param comp
     */
    public DictionaryTreeRedAndBlack(Dictionary<K, V> dictionary, Comparator<K> comp) {
	this(comp);
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();) {
	    this.put(key = keys.nextElement(), dictionary.get(key));
	}
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
	ContainerDictionary<K, V> cont = null;
	cont = tree.remove(new ContainerDictionary<K, V>((K) key, null));
	if (cont != null)
	    return cont.value;
	else
	    return null;
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