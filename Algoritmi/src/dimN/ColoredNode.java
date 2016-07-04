package dimN;

/**
 * @param <T>
 */
public class ColoredNode<T> extends BinaryNode<T, ColoredNode<T>> {
    public enum Color {
	RED, BLACK
    }

    private Color color;

    /**
     * @param val
     * @param color
     * @param father
     * @param left
     * @param right
     */
    public ColoredNode(T val, Color color, ColoredNode<T> father, ColoredNode<T> left, ColoredNode<T> right) {
	super(val, father, left, right);
	this.color = color;
    }

    /**
     * @param val
     * @param color
     */
    public ColoredNode(T val, Color color) {
	this(val, color, null, null, null);
    }

    /**
     * @param val
     */
    public ColoredNode(T val) {
	this(val, Color.RED);
    }

    /**
     * @param color
     */
    public void setColor(Color color) {
	this.color = color;
    }

    /**
     * @return
     */
    public Color getColor() {
	return this.color;
    }

    /*
     * (non-Javadoc)
     * 
     * @see dimN.Node#toString()
     */
    @Override
    public String toString() {
	return super.toString() + ":" + color;
    }
}
