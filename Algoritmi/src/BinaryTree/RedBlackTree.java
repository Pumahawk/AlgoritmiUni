package BinaryTree;

import java.util.Comparator;

/**
 * 
 * @param <T>
 */
public class RedBlackTree<T> {
    /**
     *
     */
    private class Node {
	private T value;
	/*
	 * color black: true; color red: false;
	 */
	private boolean color = true;
	private Node father = null;
	private Node leftChild = null;
	private Node rightChild = null;

	public Node(T value, boolean color, Node father, Node left, Node right) {
	    setValue(value);
	    setColor(color);
	    setFather(father);
	    setLeft(left);
	    setRight(right);
	}

	public Node(T value, boolean color) {
	    this(value, color, null, null, null);
	}

	public T getValue() {
	    return this.value;
	}

	public boolean getColor() {
	    return this.color;
	}

	public Node getFather() {
	    return father;
	}

	public Node getLeft() {
	    return leftChild;
	}

	public Node getRight() {
	    return rightChild;
	}

	public void setValue(T value) {
	    this.value = value;
	}

	public void setColor(boolean c) {
	    this.color = c;
	}

	public void setFather(Node father) {
	    this.father = father;
	}

	public void setLeft(Node left) {
	    this.leftChild = left;
	}

	public void setRight(Node right) {
	    this.rightChild = right;
	}
    }

    /*
     * Attribute:
     */

    private T root = null;
    private Comparator<T> comparator;
    private int size = 0;

    public RedBlackTree(Comparator<T> comp) {
	setComparator(comp);
    }

    public void setComparator(Comparator<T> c) {
	this.comparator = c;
    }

    public void add(T value) {
	// Code to do
	this.size++;
    }

    public boolean remove(T value) {
	// Code to do
	this.size--;
	return true;
    }

    private void leftRotate(Node nodo) {

    }

    private void rightRotate(Node nodo) {

    }

}
