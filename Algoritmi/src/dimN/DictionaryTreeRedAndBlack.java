package dimN;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @param <K>
 * @param <V>
 * @param <T>
 */
public class DictionaryTreeRedAndBlack<K, V>
	extends DictionaryTree<K, V, RedAndBlackTree<ContainerDictionary<K,V>>> {

    public DictionaryTreeRedAndBlack(Comparator<K> comp) {
	this.tree = new RedAndBlackTree<>(ContainerDictionary.getComparator(comp));
    }

    public DictionaryTreeRedAndBlack(Dictionary<K, V> dictionary, Comparator<K> comp) {
	this(comp);
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();) {
	    this.put(key = keys.nextElement(), dictionary.get(key));
	}
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