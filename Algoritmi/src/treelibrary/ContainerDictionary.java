package treelibrary;

import java.util.Comparator;

/**
 * Classe utilizzata per racchiudere al suo interno una coppia di oggetti
 * utilizzati come chiave e valore nella struttura a dizionario
 * 
 * @author Lorenzo Gandino
 *
 * @param <K>
 *            Tipo di chiave
 * @param <V>
 *            Tipo di valore
 */
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

    @Override
    public String toString() {
	return "[" + key + "](" + value + ")";
    }

    /**
     * converte un comparatore di sole chiavi un un comparatore di
     * ContainerDictionary
     * 
     * @param il comparatore di chiavi da convertire
     * @return un comparatore di container
     */
    static public <K2, V2> Comparator<ContainerDictionary<K2, V2>> getComparator(Comparator<K2> comp) {
	return (ContainerDictionary<K2, V2> a, ContainerDictionary<K2, V2> b) -> comp.compare(a.key, b.key);
    }
}
