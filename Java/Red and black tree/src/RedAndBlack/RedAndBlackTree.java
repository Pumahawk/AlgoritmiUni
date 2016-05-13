package RedAndBlack;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;

public class RedAndBlackTree<K, V> extends Dictionary<K, V> {
    private enum Color {
	RED, BLACK;
    }

    private class Node {
	public V value;
	public K key;
	public Color color;
	public Node father = null;
	public Node leftChild = null;
	public Node rightChild = null;

	public Node(V value, Color color, Node father, Node left, Node right) {
	    this.value = value;
	    this.color = color;
	    this.father = father;
	    this.leftChild = left;
	    this.rightChild = right;
	}

	public Node(V value, Color color) {
	    this(value, color, null, null, null);
	}
    }
    

    private Node root;
    private Comparator<K> comparator;
    private int size = 0;

    public RedAndBlackTree(Comparator<K> comp) {
	setComparator(comp);
	root = null;
    }

    public void setComparator(Comparator<K> c) {
	this.comparator = c;
    }

    public void add(V value) {
	// Code to do
	this.size++;
    }

    private void leftRotate(Node nodo) {
	// Sinistra: true
	// Destra: false
	boolean verso;
	Node padre = nodo.father;

	if (padre != null) {
	    verso = padre.leftChild == nodo;
	    if (verso)
		padre.leftChild = nodo.rightChild;
	    else
		padre.rightChild = nodo.rightChild;
	} else
	    this.root = nodo.rightChild;
	Node p = nodo.rightChild.leftChild;
	nodo.rightChild.leftChild = nodo;
	nodo.rightChild = p;

    }

    private void rightRotate(Node nodo) {
	// Sinistra: true
	// Destra: false
	boolean verso;
	Node padre = nodo.father;

	if (padre != null) {
	    verso = padre.leftChild == nodo;
	    if (verso)
		padre.leftChild = nodo.leftChild;
	    else
		padre.rightChild = nodo.leftChild;
	} else
	    this.root = nodo.leftChild;
	Node p = nodo.rightChild.leftChild;
	nodo.leftChild.leftChild = nodo;
	nodo.leftChild = p;
    }

    @Override
    public Enumeration<V> elements() {
	// TODO Auto-generated method stub
	
	return null;
    }

    @Override
    public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public Enumeration<K> keys() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public V get(Object key) {
	// TODO Auto-generated method stub
	return null;
    }
    
    private Node getNode(K key, Node node) {
	if (node != null)
	    if (comparator.compare(node.key, key) < 0)
		return getNode(key, node.leftChild);
	    else if (comparator.compare(node.key, key) == 0)
		return node;
	    else
		return getNode(key, node.leftChild);
	else
	    return null;
    }
    
    private Node getNode(K key){
	return getNode(key, root);
    }

    @Override
    public V put(K key, V value) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public V remove(Object key) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int size() {
	// TODO Auto-generated method stub
	return 0;
    }
}
