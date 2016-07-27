package dimN;

/**
 * BinaryNode rappresenta un generico nodo di un generico albero. E' costituito
 * da una variabile "vaule" contente il valore del nodo, e 3 collegamenti ad
 * altri nodi generici di tipo BinaryNode corrispondenti al padre, figlio destro
 * e figlio sinistro del nodo.
 * 
 * @param <V>
 *            Il tipo di oggetto che puo contentere il nodo.
 * @param <P>
 *            Il tipo di nodo del padre e dei figlio.
 */
public abstract class BinaryNode<V, P extends BinaryNode<V, P>> {

    /**
     * Oggetto memorizzato nel nodo.
     */
    private V value;
    /**
     * Nodo padre del nodo.
     */
    private P father;

    /**
     * Nodo figlio sinistro del nodo.
     */
    private P left;

    /**
     * Nodo figlio destro del nodo.
     */
    private P right;

    /**
     * Costruttore che permette di creare un nodo specificando il suo contenuto
     * e i suoi collegamenti.
     * 
     * @param val
     *            Oggetto memorizzato nel nodo.
     * @param father
     *            Nodo padre che punta al presente nodo.
     * @param left
     *            Nodo figlio sinistro del nodo.
     * @param right
     *            Nodo figlio destro del nodo.
     */
    public BinaryNode(V value, P father, P left, P right) {
	this.value = value;
	this.father = father;
	this.left = left;
	this.right = right;
    }

    /**
     * Costruttore che permette la creazione di un nodo specificando solo
     * l'oggetto da memorizzare al suo interno. Tutti i collegamenti saranno
     * impostati a <b>null</b>.
     * 
     * @param value
     *            Oggetto memorizzato nel nodo.
     */
    public BinaryNode(V value) {
	this(value, null, null, null);
    }

    /**
     * Costruttore che permette la creazione di un nodo senza specificare il suo
     * contenuto e i suoi collegamenti. Contenuto, Padre e figli saranno
     * impostati a <b>null</b>.
     */
    public BinaryNode() {
	this(null);
    }

    /**
     * @return Consiste nell'oggetto contenuto nel nodo.
     */
    public V value() {
	return this.value;
    }

    /**
     * @return Consiste nel padre del nodo.
     */
    public P father() {
	return this.father;
    }

    /**
     * @return Consiste nel figlio sinistro del nodo.
     */
    public P left() {
	return this.left;
    }

    /**
     * @return Consiste nel figlio destro del nodo.
     */
    public P right() {
	return this.right;
    }

    /**
     * Permette di collegare impostare l'oggetto da contenere nel nodo.
     * 
     * @param value
     *            Rappresenta il valore che andrà a sostituire il contenuto del
     *            nodo.
     * @return Il precedente valore del nodo.
     */
    public V setValue(V value) {
	V ret = this.value;
	this.value = value;
	return ret;
    }

    /**
     * @param father
     *            Rappresenta il nuovo padre del nodo.
     * @return Il padre precedente
     */
    public P setFather(P father) {
	P ret = this.father;
	this.father = father;
	return ret;
    }

    /**
     * @param left
     *            Rappresenta il nuovo figlio sinistro del nodo.
     * @return Il figlio sinistro precedente
     */
    public P setLeft(P left) {
	P ret = this.left;
	this.left = left;
	return ret;
    }

    /**
     * @param right
     *            Rappresenta il nuovo figlio destro del nodo.
     * @return Il figlio destro precedente.
     */
    public P setRight(P right) {
	P ret = this.right;
	this.right = right;
	return ret;
    }

}
