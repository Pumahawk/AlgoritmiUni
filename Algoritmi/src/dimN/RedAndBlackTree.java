package dimN;

import java.util.Comparator;

public class RedAndBlackTree<V> extends Tree<V, ColoredNode<V>> {

    public RedAndBlackTree(Comparator<V> comp) {
	super(comp);
    }

    @Override
    public V put(V val) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public V remove(ColoredNode<V> val) {
	// TODO fare l'override
	return null;
    }

    private void leftRotate(ColoredNode<V> nodo) {
	// Sinistra: true
	// Destra: false
	boolean verso;
	ColoredNode<V> padre = nodo;

	if (padre != null) {
	    verso = padre.left() == nodo;
	    if (verso)
		padre.setLeft(nodo.right());
	    else
		padre.setRight(nodo.right());
	} else
	    this.root = nodo.right();
	ColoredNode<V> p = nodo.right().left();
	nodo.right().setLeft(nodo);
	nodo.setRight(p);

    }

    private void rightRotate(ColoredNode<V> nodo) {
	// Sinistra: true
	// Destra: false
	boolean verso;
	ColoredNode<V> padre = nodo;

	if (padre != null) {
	    verso = padre.left() == nodo;
	    if (verso)
		padre.setLeft(nodo.left());
	    else
		padre.setRight(nodo.left());
	} else
	    this.root = nodo.left();
	ColoredNode<V> p = nodo.right().left();
	nodo.left().setLeft(nodo);
	nodo.setLeft(p);
    }

}
