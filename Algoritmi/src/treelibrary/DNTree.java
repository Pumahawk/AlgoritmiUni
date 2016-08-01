package treelibrary;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * Implementazione di un dizionario che utilizza un albero normale per
 * organizzare i suoi dati
 * 
 * @author Lorenzo Gandino
 *
 * @param <K> Tipo di chiave
 * @param <V> Tipo di valore
 */

public class DNTree<K, V> extends DTree<K, V, NormalTree<ContainerDictionary<K, V>>> {
/**
 * Il comparatore serve per il normale funzionamento dell'albero
 * @param comp
 */
    public DNTree(Comparator<K> comp) {
	super(comp);
    }

    public DNTree(Dictionary<K, V> dictionary, Comparator<K> comp) {
    super(dictionary, comp);
}

    @Override
    protected NormalTree<ContainerDictionary<K, V>> instanceTree(Comparator<K> comp) {
	return new NormalTree<>(ContainerDictionary.getComparator(comp));
    }

}
