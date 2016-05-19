package dimN;

/**
 * Rappresenta il nodo tipico di un albero. Possiede 3 puntatori: father per
 * putare al nodo padre, left e right per puntare ai nodi figli. La classe
 * permette di mischiare varie strutture e non necessariamene deve essere
 * utilizzata soltanto negli alberi.
 * 
 * @author Lorenzo Gandino
 *
 * @param <C>
 *            Valore informativo contenuto in un nodo
 * @param <P>
 *            Tipo di nodo a cui i puntatori sono rivolti
 */
public class BinaryNode<V, P extends Node<V>> extends Node<V> {
    /**
     * Puntatore al nodo padre.
     */
    private P father;
    /**
     * Puntatore al nodo radice del sottoalbero sinistro.
     */
    private P left;
    /**
     * Puntatore al nodo radice del sottoalbero destro
     */
    private P right;

    public BinaryNode(V val, P father, P left, P right) {
	super(val);
	setFather(father);
	setLeft(left);
	setRight(right);
    }

    public BinaryNode(V val) {
	this(val, null, null, null);
    }

    public BinaryNode() {
	this(null, null, null, null);
    }

    public P father() {
	return this.father;
    }

    public P left() {
	return this.left;
    }

    public P right() {
	return this.right;
    }

    public void setFather(P father) {
	this.father = father;
    }

    public void setLeft(P left) {
	this.left = left;
    }

    public void setRight(P right) {
	this.right = right;
    }

}
