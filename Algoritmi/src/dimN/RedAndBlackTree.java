package dimN;

import java.util.Comparator;

import dimN.ColoredNode.Color;

public class RedAndBlackTree<V> extends Tree<V, ColoredNode<V>> {
    // TODO Controllare i null pointer exception

    public enum Case {
	ONE, TWO, THREE, FOUR, FIVE
    }

    public RedAndBlackTree(Comparator<V> comp) {
	super(comp);
    }

    @Override
    public V put(V val) {
	V ret = null;
	ColoredNode<V> node = getNodeForValue(val);
	if (node.value() != null)
	    ret = node.value();
	node.setValue(val);
	solveCase(node, findCase(node));
	return ret;
    }

    protected Case findCase(ColoredNode<V> node) {
	// TODO
	// TODO controllare i null pointer exception
	if (node.father() == null)
	    return Case.ONE;
	else if (node.father().getColor() == Color.BLACK)
	    return Case.TWO;
	else {
	    ColoredNode<V> father, uncle;
	    father = node.father();
	    uncle = (father.father().left() != father) ? father.father().left() : father.father().right();
	    if (uncle != null && uncle.getColor() == Color.RED)
		return Case.THREE;
	    else if ((node == node.father().right() && node.father() == node.father().father().left())
		    || (node == node.father().left() && node.father() == node.father().father().right()))
		return Case.FOUR;
	    else
		return Case.FIVE;
	}
    }

    protected void solveCase(ColoredNode<V> node, Case caso) {
	switch (caso) {
	case ONE:
	    solveCaseOne(node);
	    break;
	case TWO:
	    solveCaseTwo(node);
	    break;
	case THREE:
	    solveCaseThree(node);
	    break;
	case FOUR:
	    solveCaseFour(node);
	    break;
	case FIVE:
	    solveCaseFive(node);
	    break;
	}
    }

    protected void solveCaseOne(ColoredNode<V> node) {
	this.root.setColor(Color.BLACK);
    }

    protected void solveCaseTwo(ColoredNode<V> node) {
	return;
    }

    protected void solveCaseThree(ColoredNode<V> node) {
	ColoredNode<V> gParent = node.father().father();
	gParent.setColor(Color.RED);
	gParent.left().setColor(Color.BLACK);
	gParent.right().setColor(Color.BLACK);

	solveCase(gParent, findCase(gParent));

    }

    protected void solveCaseFour(ColoredNode<V> node) {
	if (node == node.father().right() && node.father() == node.father().father().left()) {
	    leftRotate(node.father());
	    node = node.left();
	} else if (node == node.father().left() && node.father() == node.father().father().right()) {
	    rightRotate(node.father());
	    node = node.right();
	}
	solveCaseFive(node);
    }

    protected void solveCaseFive(ColoredNode<V> node) {
	node.father().setColor(Color.BLACK);
	node.father().father().setColor(Color.RED);
	if (node == node.father().left() && node.father() == node.father().father().left())
	    rightRotate(node.father().father());
	else
	    leftRotate(node.father().father());
    }

    protected ColoredNode<V> getNodeForValue(V value) {
	if (root == null) {
	    root = new ColoredNode<>(null, Color.RED);
	    return root;
	} else
	    return getNodeForValue(value, root);
    }

    protected ColoredNode<V> getNodeForValue(V value, ColoredNode<V> node) {
	if (comparator.compare(value, node.value()) == 0)
	    return node;
	else if (comparator.compare(value, node.value()) < 0)
	    if (node.left() != null)
		return getNodeForValue(value, node.left());
	    else {
		node.setLeft(new ColoredNode<>(null, Color.RED, node, null, null));
		return node.left();
	    }
	else if (node.right() != null)
	    return getNodeForValue(value, node.right());
	else {
	    node.setRight(new ColoredNode<>(null, Color.RED, node, null, null));
	    return node.right();
	}
    }

    @Override
    public V removeNode(ColoredNode<V> val) {
	// TODO fare l'override
	return null;
    }

    private void leftRotate(ColoredNode<V> nodo) {
	ColoredNode<V> padre = nodo.father();
	nodo.right().setFather(nodo.father());
	nodo.setFather(nodo.right());
	if (nodo.right().left() != null)
	    nodo.right().left().setFather(nodo);

	if (padre != null)
	    if (padre.left() == nodo)
		padre.setLeft(nodo.right());
	    else
		padre.setRight(nodo.right());
	else
	    this.root = nodo.right();
	ColoredNode<V> p = nodo.right().left();
	nodo.right().setLeft(nodo);
	nodo.setRight(p);

    }

    private void rightRotate(ColoredNode<V> nodo) {
	ColoredNode<V> padre = nodo.father();
	nodo.left().setFather(nodo.father());
	nodo.setFather(nodo.left());
	if (nodo.left().right() != null)
	    nodo.left().right().setFather(nodo);

	if (padre != null)
	    if (padre.left() == nodo)
		padre.setLeft(nodo.left());
	    else
		padre.setRight(nodo.left());
	else
	    this.root = nodo.left();
	ColoredNode<V> p = nodo.left().right();
	nodo.left().setRight(nodo);
	nodo.setLeft(p);
    }

}
