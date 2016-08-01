package graphs;

import java.util.HashMap;

/**
 * Vertice del grafo
 * 
 * @param <V>
 *            tipo di valore
 */
class Vertex<V> {

    private V value;
    public HashMap<Vertex<V>, Edge<V>> neightbor;

    public Vertex(V value, HashMap<Vertex<V>, Edge<V>> edge) {
	this.value = value;
	this.neightbor = edge;
    }

    public V getValue() {
	return this.value;
    }

    /**
     * Controlla se ha un nodo come vicino
     */
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
	    this.neightbor.put(neightbor, new Edge<V>(neightbor, weight));
    }

    public HashMap<Vertex<V>, Edge<V>> getNeightbor() {
	return this.neightbor;
    }
}
