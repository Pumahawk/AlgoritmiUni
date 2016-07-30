package graphs;

class Edge<V> {
    public Vertex<V> vertex;
    public float weight;

    public Edge(Vertex<V> vertex, float weight) {
	this.vertex = vertex;
	this.weight = weight;
    }
}
