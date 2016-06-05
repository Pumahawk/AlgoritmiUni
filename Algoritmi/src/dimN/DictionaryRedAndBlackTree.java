package dimN;

import java.util.Comparator;
import java.util.Enumeration;

public class DictionaryRedAndBlackTree<K, V>
	extends DictionaryTreeRedAndBlack<K, V, RedAndBlackTree<ContainerDictionary<K, V>>> {

    public DictionaryRedAndBlackTree(Comparator<K> comp) {
	super(comp);
	this.tree = new RedAndBlackTree<ContainerDictionary<K, V>>(ContainerDictionary.getComparator(comp));
    }

    public static void main(String args[]) {
	Comparator<Integer> comp = (Integer a, Integer b) -> a.compareTo(b);
	DictionaryRedAndBlackTree<Integer, String> dc = new DictionaryRedAndBlackTree<Integer, String>(comp);
	for (int i = 0; i < 100; i++)
	    dc.put(i, "Ciao");
	System.out.println(dc.remove(1));
	Enumeration<?> en = dc.keys();
	while (en.hasMoreElements())
	    System.out.println(en.nextElement());
	return;
    }
}
