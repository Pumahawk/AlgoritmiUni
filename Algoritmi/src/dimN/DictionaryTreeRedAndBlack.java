package dimN;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * @param <K>
 * @param <V>
 * @param <T>
 */
public class DictionaryTreeRedAndBlack<K, V> extends DictionaryTree<K, V, RedAndBlackTree<ContainerDictionary<K, V>>> {

    public DictionaryTreeRedAndBlack(Comparator<K> comp) {
	super(comp);
    }

    public DictionaryTreeRedAndBlack(Dictionary<K, V> dictionary, Comparator<K> comp) {
	this(comp);
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();) {
	    this.put(key = keys.nextElement(), dictionary.get(key));
	}
    }

    @Override
    protected RedAndBlackTree<ContainerDictionary<K, V>> instanceTree(Comparator<K> comp) {
	return new RedAndBlackTree<>(ContainerDictionary.getComparator(comp));
    }

}