package dimN;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

public class DictionaryNormalTree<K, V> extends DictionaryTree<K, V, NormalTree<ContainerDictionary<K, V>>> {

    public DictionaryNormalTree(Comparator<K> comp) {
	this.tree = new NormalTree<>(ContainerDictionary.getComparator(comp));
    }

    public DictionaryNormalTree(Dictionary<K, V> dictionary, Comparator<K> comp) {
	this(comp);
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();) {
	    this.put(key = keys.nextElement(), dictionary.get(key));
	}
    }

}
