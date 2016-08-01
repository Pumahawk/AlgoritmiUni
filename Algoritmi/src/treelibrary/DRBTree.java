package treelibrary;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * Implementazione di un dizionario che utilizza una struttura di una labero
 * roso e nero
 * 
 * @param <K>
 *            Tipo di chiave
 * @param <V>
 *            Tipo di valore
 */
public class DRBTree<K, V> extends DTree<K, V, RBTree<ContainerDictionary<K, V>>> {

    public DRBTree(Comparator<K> comp) {
	super(comp);
    }

    public DRBTree(Dictionary<K, V> dictionary, Comparator<K> comp) {
	super(dictionary, comp);
    }

    @Override
    protected RBTree<ContainerDictionary<K, V>> instanceTree(Comparator<K> comp) {
	return new RBTree<>(ContainerDictionary.getComparator(comp));
    }

}