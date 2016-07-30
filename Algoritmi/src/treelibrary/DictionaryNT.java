package treelibrary;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

public class DictionaryNT<K, V> extends DictionaryTree<K, V, NormalTree<ContainerDictionary<K, V>>> {

    public DictionaryNT(Comparator<K> comp) {
	super(comp);
    }

    public DictionaryNT(Dictionary<K, V> dictionary, Comparator<K> comp) {
	this(comp);
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();) {
	    this.put(key = keys.nextElement(), dictionary.get(key));
	}
    }

    @Override
    protected NormalTree<ContainerDictionary<K, V>> instanceTree(Comparator<K> comp) {
	return new NormalTree<>(ContainerDictionary.getComparator(comp));
    }

}
