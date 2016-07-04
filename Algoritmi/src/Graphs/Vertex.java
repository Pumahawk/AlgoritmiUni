package Graphs;

import java.util.HashMap;

public class Vertex<V> {
    public class Edge {
	public Vertex<V> vertex;
	public float weight;

	public Edge(Vertex<V> vertex, float weight) {
	    this.vertex = vertex;
	    this.weight = weight;
	}
    }

    private V value;
    public HashMap<Vertex<V>, Edge> neightbor;

    public Vertex(V value, HashMap<Vertex<V>, Edge> edge) {
	this.value = value;
	this.neightbor = edge;
    }

    public V getValue() {
	return this.value;
    }

    public boolean hasNeightbor(Vertex<V> neightbor) {
	return this.neightbor.containsKey(neightbor);
    }

    public float getWeight(Vertex<V> neightbor) {
	return this.neightbor.get(neightbor).weight;
    }

    public void setWeight(Vertex<V> neightbor, int weight) {
	this.neightbor.get(neightbor).weight = weight;
    }

    public void setNeigthBor(Vertex<V> neightbor, float weight) {
	if (this != neightbor)
	    this.neightbor.put(neightbor, new Edge(neightbor, weight));
    }

    public HashMap<Vertex<V>, Edge> getNeightbor() {
	return this.neightbor;
    }
}
