package treelibrary;

import java.util.Comparator;

import treelibrary.NodeRBTree.Color;

/**
 * Rappresenta un albero rosso e nero
 *
 * @param <V>
 *            tipo di valore dell'oggetto contenuto nei singoli nodi
 */
public class RBTree<V> extends Tree<V, NodeRBTree<V>> {

    public enum Case {
	ONE, TWO, THREE, FOUR, FIVE
    }

    public RBTree(Comparator<V> comp) {
	super(comp);
    }
    @Override
    public V put(V val) {
	V ret = null;
	NodeRBTree<V> node = getNodeByValue(val);
	if (node.value() != null)
	    ret = node.value();
	node.setValue(val);
	if (ret == null)
	    solveCasePut(node, findCase(node));
	return ret;
    }

    /**
     * Permette di trovare capire in che caso ci si trova dopo l'inserimento del
     * nodo per riformattare l'albero
     * 
     * @param node
     * @return
     */
    protected Case findCase(NodeRBTree<V> node) {
	if (node.father() == null)
	    return Case.ONE;
	else if (node.father().getColor() == Color.BLACK)
	    return Case.TWO;
	else {
	    NodeRBTree<V> father, uncle;
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

    protected void solveCasePut(NodeRBTree<V> node, Case caso) {
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

    protected void solveCaseOne(NodeRBTree<V> node) {
	this.root.setColor(Color.BLACK);
    }

    protected void solveCaseTwo(NodeRBTree<V> node) {
	return;
    }

    protected void solveCaseThree(NodeRBTree<V> node) {
	NodeRBTree<V> gParent = node.father().father();
	gParent.setColor(Color.RED);
	gParent.left().setColor(Color.BLACK);
	gParent.right().setColor(Color.BLACK);

	solveCasePut(gParent, findCase(gParent));

    }

    protected void solveCaseFour(NodeRBTree<V> node) {
	if (node == node.father().right() && node.father() == node.father().father().left()) {
	    leftRotate(node.father());
	    node = node.left();
	} else if (node == node.father().left() && node.father() == node.father().father().right()) {
	    rightRotate(node.father());
	    node = node.right();
	}
	solveCaseFive(node);
    }

    protected void solveCaseFive(NodeRBTree<V> node) {
	node.father().setColor(Color.BLACK);
	node.father().father().setColor(Color.RED);
	if (node == node.father().left() && node.father() == node.father().father().left())
	    rightRotate(node.father().father());
	else
	    leftRotate(node.father().father());
    }

    protected NodeRBTree<V> getNodeByValue(V value) {
	if (root == null) {
	    root = new NodeRBTree<>(null, Color.RED);
	    return root;
	} else
	    return getNodeByValue(value, root);
    }

    protected NodeRBTree<V> getNodeByValue(V value, NodeRBTree<V> node) {
	if (comparator.compare(value, node.value()) == 0)
	    return node;
	else if (comparator.compare(value, node.value()) < 0)
	    if (node.left() != null)
		return getNodeByValue(value, node.left());
	    else {
		node.setLeft(new NodeRBTree<>(null, Color.RED, node, null, null));
		return node.left();
	    }
	else if (node.right() != null)
	    return getNodeByValue(value, node.right());
	else {
	    node.setRight(new NodeRBTree<>(null, Color.RED, node, null, null));
	    return node.right();
	}
    }

    @Override
    public V remove(V value) {
	NodeRBTree<V> node = getNode(value, root);
	V ret = null;
	if (node != null) {
	    ret = node.value();
	    if (node.left() == null)
		removeOneChild(node, node.right());
	    else if (node.right() == null)
		removeOneChild(node, node.left());
	    else {
		NodeRBTree<V> minOfMax = findMinOfMax(node);
		if (minOfMax == node)
		    minOfMaxIsNode(node);
		else
		    minOfMaxIsNotNode(node, minOfMax);
	    }
	}
	return ret;
    }

    private void removeOneChild(NodeRBTree<V> node, NodeRBTree<V> child) {
	if (child != null) {
	    child.setValue(root.value());
	    if (node == root)
		if (node.getColor() == Color.RED) {
		    root = child;
		} else if (child.getColor() == Color.RED) {
		    child.setColor(Color.BLACK);
		    root = child;
		} else {
		    root = child;
		    solveCaseOneRemove(root);
		}
	    else if (node.getColor() == Color.RED)
		leaveFather(node, child);
	    else if (child.getColor() == Color.RED) {
		child.setColor(Color.BLACK);
		leaveFather(node, child);
	    } else {
		leaveFather(node, child);
		solveCaseOneRemove(child);
	    }
	} else if (node == root)
	    root = null;
	else
	    leaveFather(node);

    }
    private void minOfMaxIsNode(NodeRBTree<V> node) {
	if (node == root)
	    root = null;
	else
	    leaveFather(node);
    }

    private void minOfMaxIsNotNode(NodeRBTree<V> node, NodeRBTree<V> minOfMax) {
	node.setValue(minOfMax.value());
	if (minOfMax.right() != null)
	    removeOneChild(minOfMax, minOfMax.right());
	else if (minOfMax.left() != null)
	    removeOneChild(minOfMax, minOfMax.left());
	else
	    leaveFather(minOfMax);
    }

    NodeRBTree<V> brother(NodeRBTree<V> node) {
	return (node.father().left() != node) ? node.father().left() : node.father().right();
    }

    private void solveCaseOneRemove(NodeRBTree<V> node) {
	if (node.father() == null)
	    return;
	else
	    solveCaseTwoRemove(node);
    }

    private void solveCaseTwoRemove(NodeRBTree<V> node) {
	if (brother(node).getColor() == Color.RED) {
	    node.father().setColor(Color.RED);
	    brother(node).setColor(Color.BLACK);
	    if (node == node.father().left())
		leftRotate(node.father());
	    else
		rightRotate(node.father());
	}
	solveCaseThreeRemove(node);
    }

    private void solveCaseThreeRemove(NodeRBTree<V> node) {

	if (node.father().getColor() == Color.BLACK && brother(node).getColor() == Color.BLACK
		&& brother(node).left().getColor() == Color.BLACK && brother(node).right().getColor() == Color.BLACK) {
	    brother(node).setColor(Color.RED);
	    solveCaseOneRemove(node.father());
	} else
	    solveCaseFourRemove(node);

    }

    private void solveCaseFourRemove(NodeRBTree<V> node) {
	if (node.father().getColor() == Color.RED && brother(node).getColor() == Color.BLACK
		&& brother(node).left().getColor() == Color.BLACK && brother(node).right().getColor() == Color.BLACK) {
	    brother(node).setColor(Color.RED);
	    node.father().setColor(Color.BLACK);
	} else
	    solveCaseFiveRemove(node);
    }

    private void solveCaseFiveRemove(NodeRBTree<V> node) {
	if (node == node.father().left() && brother(node).getColor() == Color.BLACK
		&& brother(node).left().getColor() == Color.RED && brother(node).right().getColor() == Color.BLACK) {
	    brother(node).setColor(Color.RED);
	    brother(node).left().setColor(Color.BLACK);
	    rightRotate(brother(node));
	} else if (node == node.father().right() && brother(node).getColor() == Color.BLACK
		&& brother(node).right().getColor() == Color.RED && brother(node).left().getColor() == Color.BLACK) {
	    brother(node).setColor(Color.RED);
	    brother(node).right().setColor(Color.BLACK);
	    leftRotate(brother(node));
	}
	solveCaseSixRemove(node);
    }

    private void solveCaseSixRemove(NodeRBTree<V> node) {
	brother(node).setColor(node.father().getColor());
	node.father().setColor(Color.BLACK);
	if (node == node.father().left()) {
	    brother(node).right().setColor(Color.BLACK);
	    leftRotate(node.father());
	} else {
	    brother(node).left().setColor(Color.BLACK);
	    rightRotate(node.father());
	}
    }

    private void leftRotate(NodeRBTree<V> nodo) {
	NodeRBTree<V> padre = nodo.father();
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
	NodeRBTree<V> p = nodo.right().left();
	nodo.right().setLeft(nodo);
	nodo.setRight(p);

    }

    private void rightRotate(NodeRBTree<V> nodo) {
	NodeRBTree<V> padre = nodo.father();
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
	NodeRBTree<V> p = nodo.left().right();
	nodo.left().setRight(nodo);
	nodo.setLeft(p);
    }

}
