package dimN;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * 
 * Albero binario in cui tutti i nodi rispettano la seguente condizione: <br>
 * La chiave contenuta nel nodo è strettamente maggiore della chiave contenuta
 * nel nodo puntato dal puntatore sinistra e minore o uguale della chiave
 * contenuta nel nodo puntato dal puntatore destro.
 * 
 * @author Lorenzo Gandino
 *
 * @param <K>
 *            Tipo di chiave
 * @param <V>
 *            Tipo del valore da memorizzare
 */
public class BinaryTree<K, V> extends Dictionary<K, V> {
    /**
     * Permette la direzione in cui spostarsi per passare al nodo successivo nel
     * metodo Enum.nextElement().
     * 
     * @author Lorenzo Gandino
     *
     */
    public enum Direction {
	NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST;
    }

    /**
     * classe che permette di accoppiare 2 valori in un unico oggeto
     * 
     * @author Lorenzo Gandino
     *
     */
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

	public String toString() {
	    return "[" + key + "](" + value + ")";
	}
    }

    private class PBinaryNode extends BinaryNode<Content, PBinaryNode> {

	public PBinaryNode(Content val, PBinaryNode father, PBinaryNode left, PBinaryNode right) {
	    super(val, father, left, right);
	}

	public PBinaryNode(Content val) {
	    this(val, null, null, null);
	}
    }

    /**
     * Classe utilizzata per gestire la enumerazione e permettere di spostarsti
     * tra un nodo e l'altro dell'albero nella maniera piu corretta
     * 
     * @author Lorenzo Gandino
     *
     */
    private class Enum implements Enumeration<V> {
	public PBinaryNode punt;
	public Direction direction;

	public Enum(PBinaryNode punt) {
	    this.punt = punt;

	}

	@Override
	public boolean hasMoreElements() {
	    return punt != null;
	}

	@Override
	public V nextElement() {
	    // TODO;
	    return null;
	}

    }

    /**
     * Indica il numero di nodi presenti nell'albero
     */
    protected int size = 0;
    /**
     * primo nodo dell'albero
     */
    protected PBinaryNode root = null;
    /**
     * Comparatore utilizzato per confrontare correttamente le chiavi
     */
    protected Comparator<K> comparator;

    /**
     * Permette di creare un nodo passando il comparatore
     * 
     * @param comp
     *            comparatore utilizzato per confrontare le chiavi
     */
    public BinaryTree(Comparator<K> comp) {
	this.comparator = comp;
    }

    /**
     * Costruttore creato per permettere di creare un albero partendeo da
     * un'altra struttura a dizionario
     * 
     * @param dictionary
     *            Dizionario da cui creare l'albero
     * @param comp
     *            Comparatore per confrontare le chiavi
     */
    public BinaryTree(Dictionary<K, V> dictionary, Comparator<K> comp) {
	Enumeration<K> keys = dictionary.keys();
	for (K key; keys.hasMoreElements();)
	    this.put(key = keys.nextElement(), dictionary.get(key));
	this.size = dictionary.size();
    }

    @Override
    public Enumeration<V> elements() {
	// TODO
	return null;
    }

    @Override
    public V get(Object arg0) {
	return get(arg0, root);
    }

    private V get(Object key, PBinaryNode punt) {
	PBinaryNode nodo = getNode((K) key, punt);

	return (nodo != null) ? nodo.value().value : null;
    }

    private PBinaryNode getNode(K key, PBinaryNode punt) {
	if (punt != null)
	    return (comparator.compare(punt.value().key, (K) key) == 0) ? punt
		    : (comparator.compare((K) key, punt.value().key) < 0) ? getNode(key, punt.left())
			    : getNode(key, punt.right());
	else
	    return null;
    }

    @Override
    public boolean isEmpty() {
	return this.root == null;
    }

    @Override
    public Enumeration<K> keys() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public V put(K key, V val) {

	if (this.root == null) {
	    this.root = new PBinaryNode(new Content(key, val));
	    this.size++;
	    return null;
	} else
	    return put(key, val, root);

    }

    private V put(K key, V value, PBinaryNode node) {
	if (comparator.compare(key, node.value().key) == 0) {
	    V ret = node.value().value;
	    node.value().value = value;
	    return ret;
	} else if (comparator.compare(key, node.value().key) < 0)
	    if (node.left() != null)
		return put(key, value, node.left());
	    else {
		node.setLeft(new PBinaryNode(new Content(key, value), node, null, null));
		this.size++;
		return null;
	    }
	else if (node.right() != null) {
	    return put(key, value, node.right());
	} else {
	    node.setRight(new PBinaryNode(new Content(key, value), node, null, null));
	    this.size++;
	    return null;
	}
    }

    @Override
    public V remove(Object key) {
	return null;
	// TODO
    }

    private V remove(Object key, PBinaryNode node) {
	return null;
    }

    @Override
    public int size() {
	return size;
    }

    private void print(PBinaryNode node) {
	if (node != null) {
	    System.out.println("Chiave: " + node.value().key + " Valore: " + node.value().value);
	    print(node.left());
	    print(node.right());
	} else
	    System.out.println("Fine.");

    }

    public static void main(String args[]) {
	BinaryTree<Integer, String> albero = new BinaryTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));
	albero.put(2, "Ciao");
	albero.put(1, "A");
	albero.put(3, "Tutti");
	albero.print(albero.root);
	String parola = albero.get(2);
	return;
    }

}
