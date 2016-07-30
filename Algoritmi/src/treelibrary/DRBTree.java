package treelibrary;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * @param <K>
 * @param <V>
 * @param <T>
 */
public class DRBTree<K, V> extends DTree<K, V, RBTree<ContainerDictionary<K, V>>> {

    public DRBTree(Comparator<K> comp) {
	super(comp);
    }

    public DRBTree(Dictionary<K, V> dictionary, Comparator<K> comp) {
	this(comp);
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();) {
	    this.put(key = keys.nextElement(), dictionary.get(key));
	}
    }

    @Override
    protected RBTree<ContainerDictionary<K, V>> instanceTree(Comparator<K> comp) {
	return new RBTree<>(ContainerDictionary.getComparator(comp));
    }

}