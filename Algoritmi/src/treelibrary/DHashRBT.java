package treelibrary;

import java.util.Comparator;

public class DHashRBT<K, V> extends DTree<K, V, HashRBT<ContainerDictionary<K,V>>> {

    public DHashRBT() {
	super(null);
    }

    @Override
    protected HashRBT<ContainerDictionary<K, V>> instanceTree(Comparator<K> comp) {
	return new HashRBT<>();
    }

}
