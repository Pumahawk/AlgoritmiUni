package dimN;

import java.util.Comparator;

/**
 * @param <K>
 * @param <V>
 */
public class DictionaryRedAndBlackTree<K, V>
	extends DictionaryTreeRedAndBlack<K, V, RedAndBlackTree<ContainerDictionary<K, V>>> {

    /**
     * @param comp
     */
    public DictionaryRedAndBlackTree(Comparator<K> comp) {
	super(comp);
	this.tree = new RedAndBlackTree<ContainerDictionary<K, V>>(ContainerDictionary.getComparator(comp));
    }

}
