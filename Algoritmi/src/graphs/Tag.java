package graphs;

/**
 * Tag utilizzato per memorizzare il nodo prima di ogni nodo dirante la ricerca
 * del camino minimo
 */
class Tag<V> {
    public Vertex<V> vertex;
    public float weight;
    public Vertex<V> before;

    public Tag(Vertex<V> vertex, float weight, Vertex<V> before) {
	this.vertex = vertex;
	this.weight = weight;
	this.before = before;
    }

    public Tag(Vertex<V> vertex) {
	this(vertex, -1, null);
    }
}
