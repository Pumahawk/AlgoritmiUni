package graphs;

/**
 * Implementazione dell'arco di un nodo del grafo. L'arco consiste in un peso e
 * un nodo
 * 
 * @author Lorenzo Gandino
 *
 * @param <V>
 *            tipo di valore
 */
class Edge<V> {
    public Vertex<V> vertex;
    public float weight;

    public Edge(Vertex<V> vertex, float weight) {
	this.vertex = vertex;
	this.weight = weight;
    }
}
