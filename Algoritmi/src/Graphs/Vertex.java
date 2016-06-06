package Graphs;

import java.util.ArrayList;
import java.util.Comparator;

public class Vertex<V> {
    private V value;
    private ArrayList<Edge<V>> neighbors;
    private Comparator<V> compare;

    public Vertex(V value) {
	this.value = value;
	this.neighbors = new ArrayList<Edge<V>>();
    }

    public V getValue() {
	return this.value;
    }

    public ArrayList<Vertex<V>> getNeighbors() {
	ArrayList<Vertex<V>> myNeighbors = new ArrayList<Vertex<V>>();
	for (Edge<V> iter : this.neighbors)
	    myNeighbors.add((iter.getFirstVertex() == this) ? iter.getSecondVertex() : iter.getFirstVertex());
	return myNeighbors;
    }

    public void setValue(V val) {
	this.value = val;
    }

    public void addNeighbor(Edge<V> edge, Integer weight) {
	if (this.neighbors.contains(edge))
	    return;
	this.neighbors.add(edge);
    }

    public int hasNeighbors() {
	return this.neighbors.size();
    }

    public boolean hasNeighbor(Vertex<V> v) {
	return this.neighbors.contains(v);
    }

    public Edge<V> removeEdge(Edge<V> edge) {
	int i = 0;
	for (Edge<V> iter : this.neighbors)
	    if (iter != edge)
		i++;
	if (this.neighbors.get(i) == edge) {
	    this.neighbors.remove(i);
	    return edge;
	} else
	    return null;
    }
}
