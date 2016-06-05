package Graphs;

import java.util.ArrayList;

public class Vertex<V> {
    private V value;
    private ArrayList<Edge<V>> neighbors;

    public Vertex(V value) {
	this.value = value;
	this.neighbors = new ArrayList<Edge<V>>();
    }

    public V getValue() {
	return this.value;
    }

    public Vertex<V> getNeighbor() {
    }

    public void setValue(V val) {
	this.value = val;
    }

    public void addNeighbor(Vertex<V> ver) {
	if (this.neighbors.contains(ver))
	    return;
	this.neighbors.add(ver);
    }

    public Integer hasNeighbors(){}

    public Vertex remove(Vertex){}
}
