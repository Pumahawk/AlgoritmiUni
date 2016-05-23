package dimN;

public class ColoredNode<T> extends BinaryNode<T, ColoredNode<T>> {
    public enum Color {
	RED, BLACK
    }

    private Color color;

    public ColoredNode(T val, Color color, ColoredNode<T> father, ColoredNode<T> left, ColoredNode<T> right) {
	super(val, father, left, right);
	this.color = color;
    }

    public ColoredNode(T val, Color color) {
	this(val, color, null, null, null);
    }

    public ColoredNode(T val) {
	this(val, Color.BLACK);
    }

    public void setColor(Color color) {
	this.color = color;
    }

    public Color getColor() {
	return this.color;
    }
}
