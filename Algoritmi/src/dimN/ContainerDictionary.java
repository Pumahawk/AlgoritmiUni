package dimN;

import java.util.Comparator;

class ContainerDictionary<K, V> {
    public K key;
    public V value;

    public ContainerDictionary(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public ContainerDictionary() {
	this(null, null);
    }

    public String toString() {
	return "[" + key + "](" + value + ")";
    }

    static public <K2, V2> Comparator<ContainerDictionary<K2, V2>> getComparator(Comparator<K2> comp) {
	return (ContainerDictionary<K2, V2> a, ContainerDictionary<K2, V2> b) -> comp.compare(a.key, b.key); // TODO
    }
}
