package graphs;

/**
 * Percorso che collega 2 nodi
 */
class Path<V> {
    public V vertex;
    public float weight;

    public Path(V vertex, float weight) {
	this.vertex = vertex;
	this.weight = weight;
    }
}
