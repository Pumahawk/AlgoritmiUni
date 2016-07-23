package dimN;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

public class DictionaryNormalTree<K,V> extends DictionaryTree<K,V, NormalTree<ContainerDictionary<K,V>>>{

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
    @Override
    public V get(Object key) {
	ContainerDictionary<K, V> cont;
	cont =  (tree.get(new ContainerDictionary<>((K) key, null)));
	return (cont != null) ? cont.value : null;
    }

    @Override
    public boolean isEmpty() {
	return tree.isEmpty();
    }

    @Override
    public V put(K key, V value) {
	return tree.put(new ContainerDictionary<>(key, value)).value;
    }

    @Override
    public V remove(Object key) {
	ContainerDictionary<K, V> cont;
	cont =  (tree.remove(new ContainerDictionary<>((K) key, null)));
	return (cont != null) ? cont.value : null;
    }

    @Override
    public int size() {
	return tree.size();
    }

}
