package treelibrary;

/**
 * Rappresenta il nodo di un albero rosso e nero. Rispetto ad un nodo normale
 * contiene il colore. Di default il loro colore è il rosso.
 */
class NodeRBTree<T> extends BinaryNode<T, NodeRBTree<T>> {
    protected enum Color {
	RED, BLACK
    }

    private Color color;

    public NodeRBTree(T val, Color color, NodeRBTree<T> father, NodeRBTree<T> left, NodeRBTree<T> right) {
	super(val, father, left, right);
	this.color = color;
    }

    public NodeRBTree(T val, Color color) {
	this(val, color, null, null, null);
    }

    public NodeRBTree(T val) {
	this(val, Color.RED);
    }
    public void setColor(Color color) {
	this.color = color;
    }

    public Color getColor() {
	return this.color;
    }

    @Override
    public String toString() {
	return super.toString() + ":" + color;
    }
}
