package dimN;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;

public class BinaryTree<K, V> extends Dictionary<K, V> {

    private enum Direction {
	LEFT, RIGHT;
    }

    private class Content {
	public K key;
	public V value;

	public Content(K key, V value) {
	    this.key = key;
	    this.value = value;
	}

	public Content() {
	    this(null, null);
	}

	@Override
	public String toString() {
	    return "[" + key + "](" + value + ")";
	}
    }

    private class KEnum implements Enumeration<K> {

	// public EnumNode en;
	public Iterator<Content> it;

	public KEnum(NormalTree<Content> tr) {
	    it = tr.iterator();
	}

	@Override
	public K nextElement() {
	    return it.next().key;
	}

	@Override
	public boolean hasMoreElements() {
	    return it.hasNext();
	}

    }

    private class VEnum implements Enumeration<V> {

	// public EnumNode en;

	public Iterator<Content> it;

	public VEnum(NormalTree<Content> tr) {
	    it = tr.iterator();
	}

	@Override
	public V nextElement() {
	    return it.next().value;
	}

	@Override
	public boolean hasMoreElements() {
	    return it.hasNext();
	}

    }

    protected NormalTree<Content> tree;

    public BinaryTree(Comparator<K> comp) {
	this.tree = new NormalTree<Content>((Content o1, Content o2) -> comp.compare(o1.key, o2.key));
    }

    public BinaryTree(Dictionary<K, V> dictionary, Comparator<K> comp) {
	this(comp);
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();) {
	    this.put(key = keys.nextElement(), dictionary.get(key));
	}
    }

    @Override
    public Enumeration<V> elements() {
	return new VEnum(tree);
    }

    @Override
    public V get(Object arg0) {
	Content c = tree.get((Content) arg0);
	return (c != null) ? c.value : null;
    }

    @Override
    public boolean isEmpty() {
	return tree.isEmpty();
    }

    @Override
    public Enumeration<K> keys() {
	return new KEnum(tree);
    }

    @Override
    public V put(K key, V val) {
	Content ret = tree.put(new Content(key, val));
	return (ret != null) ? ret.value : null;

    }

    @Override
    public V remove(Object key) {
	return null;
	// TODO
    }

    @Override
    public int size() {
	return this.tree.size();
    }

    public static void main(String args[]) {
	BinaryTree<Integer, String> albero = new BinaryTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));
	albero.put(2, "Ciao");
	albero.put(1, "A");
	albero.put(3, "Tutti");
	albero.put(4, "Br**ti");
	albero.put(5, "Co****ni");
	// albero.print(albero.root);
	Enumeration<String> str = albero.elements();
	while (str.hasMoreElements())
	    System.out.println(": " + str.nextElement());
	return;
    }

}