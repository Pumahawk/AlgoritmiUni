package dimN;

import java.util.Comparator;
import java.util.Enumeration;

class DictionaryNormalTree<K, V> extends DictionaryTree<K, V, NormalTree<ContainerDictionary<K, V>>> {

    public DictionaryNormalTree(Comparator<K> comp) {
	super(comp);

	this.tree = new NormalTree<ContainerDictionary<K, V>>(ContainerDictionary.getComparator(comp));

    }

    public static void main(String args[]) {
	DictionaryNormalTree<Integer, String> albero = new DictionaryNormalTree<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	albero.put(2, "Ciao");
	albero.put(1, "A");
	albero.put(3, "Tutti");
	albero.put(4, "Br**ti");
	albero.put(5, "Co****ni");
	Enumeration<String> str = albero.elements();
	while (str.hasMoreElements())
	    System.out.println(": " + str.nextElement());
	return;
    }

}
