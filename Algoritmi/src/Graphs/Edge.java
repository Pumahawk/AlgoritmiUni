package Graphs;

public class Edge<V> {
    private Vertex<V> first;
    private Vertex<V> second;
    private int weight;

    public Edge(Vertex<V> v1, Vertex<V> v2, int weight) {
	setFirstVertex(v1);
	setSecondVertex(v2);
	setWeight(weight);
    }

    public Vertex<V> getFirstVertex() {
	return this.first;
    }

    public Vertex<V> getSecondVertex() {
	return this.second;
    }

    public void setFirstVertex(Vertex<V> v) {
	this.first = v;
    }

    public void setSecondVertex(Vertex<V> v) {
	this.second = v;
    }

    public int getWeight() {
	return this.weight;
    }

    public void setWeight(int n) {
	this.weight = n;
    }
}
