package dimN;

import java.util.Comparator;

/**
 * @author UMIT AHMED
 *
 * @param <K>
 * @param <V>
 */
class ContainerDictionary<K, V> {
    public K key;
    public V value;

    /**
     * @param key
     * @param value
     */
    public ContainerDictionary(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public ContainerDictionary() {
	this(null, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "[" + key + "](" + value + ")";
    }

    /**
     * @param comp
     * @return
     */
    static public <K2, V2> Comparator<ContainerDictionary<K2, V2>> getComparator(Comparator<K2> comp) {
	return (ContainerDictionary<K2, V2> a, ContainerDictionary<K2, V2> b) -> comp.compare(a.key, b.key); // TODO
    }
}
