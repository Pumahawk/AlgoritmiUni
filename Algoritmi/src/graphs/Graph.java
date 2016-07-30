package graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph<V> {

    public HashMap<V, Vertex<V>> vertex;
    public HashMap<V, HashMap<Vertex<V>, Edge<V>>> edge;

    public Graph() {
	this.vertex = new HashMap<>();
	this.edge = new HashMap<>();
    }

    public void addVertex(V vertex) {
	this.edge.put(vertex, new HashMap<>());
	this.vertex.put(vertex, new Vertex<V>(vertex, edge.get(vertex)));
    }

    public boolean containsVertex(V vertex) {
	return this.vertex.containsKey(vertex);
    }

    public void link(V a, V b, float weight) {
	this.vertex.get(a).setNeigthBor(this.vertex.get(b), weight);
    }

    public void unlink(V a, V b) {
	this.vertex.get(a).getNeightbor().remove(this.vertex.get(b));
    }

    public void remove(V vertex) {
	for (Vertex<V> vert : this.vertex.values())
	    unlink(vert.getValue(), vertex);
	this.vertex.remove(vertex);
    }

    public LinkedList<Path<V>> minPath(V a, V b) {
	HashMap<Vertex<V>, Tag<V>> visitati = new HashMap<>();
	HashMap<Vertex<V>, Tag<V>> daVisitare = new HashMap<>();

	daVisitare.put(this.vertex.get(a), new Tag<V>(this.vertex.get(a), 0, null));
	while (daVisitare.size() != 0) {
	    Tag<V> minTag = minTag(daVisitare);
	    for (Edge<V> edge : minTag.vertex.getNeightbor().values())
		if (daVisitare.containsKey(edge.vertex)) {
		    if (daVisitare.get(edge.vertex).weight > minTag.weight + edge.weight) {
			daVisitare.get(edge.vertex).before = minTag.vertex;
			daVisitare.get(edge.vertex).weight = minTag.weight + edge.weight;
		    }
		} else if (!visitati.containsKey(edge.vertex))
		    daVisitare.put(edge.vertex, new Tag<V>(edge.vertex, minTag.weight + edge.weight, minTag.vertex));
	    daVisitare.remove(minTag.vertex);
	    visitati.put(minTag.vertex, minTag);
	}
	LinkedList<Path<V>> ret = new LinkedList<>();
	visitati.get(this.vertex.get(b));
	Tag<V> tagList = visitati.get(this.vertex.get(b));
	while (tagList != null) {
	    ret.add(0, new Path<V>(tagList.vertex.getValue(), tagList.weight));
	    tagList = visitati.get(tagList.before);
	}
	return ret;
    }

    public Tag<V> minTag(HashMap<Vertex<V>, Tag<V>> tagList) {
	Tag<V> min = null;
	for (Tag<V> tag : tagList.values()) {
	    if (min == null)
		min = tag;
	    else if (tag.weight < min.weight)
		min = tag;
	}
	return min;
    }

    public static void main(String args[]) {
	System.out.println("Inizio");
	Graph<String> citta = new Graph<>();

	citta.addVertex("torino");
	citta.addVertex("asti");
	citta.addVertex("alessandria");
	citta.addVertex("milano");
	citta.addVertex("cuneo");
	citta.addVertex("vercelli");

	citta.link("torino", "asti", 57);
	citta.link("asti", "torino", 57);

	citta.link("torino", "cuneo", 100);
	citta.link("cuneo", "torino", 100);

	citta.link("asti", "alessandria", 39);
	citta.link("alessandria", "asti", 39);

	citta.link("alessandria", "milano", 92);
	citta.link("milano", "alessandria", 92);

	citta.link("alessandria", "vercelli", 56);
	citta.link("vercelli", "alessandria", 56);

	citta.link("vercelli", "torino", 78);
	citta.link("torino", "vercelli", 78);

	citta.link("vercelli", "milano", 83);
	citta.link("milano", "vercelli", 83);

	citta.stampaPercorso("torino", "milano");

	citta.unlink("vercelli", "milano");
	System.out.println();
	System.out.println("Strada Vercelli -> Milano chiusa");
	System.out.println();

	citta.stampaPercorso("torino", "milano");
	System.out.println();

	citta.disegnaGrafo();
    }

    public void stampaPercorso(V a, V b) {
	System.out.println(a + " -> " + b);
	for (Path<V> path : this.minPath(a, b))
	    System.out.println("Citta: " + path.vertex + "\tDistanza: " + path.weight);
    }

    public float distanzaMinima(V a, V b) {
	float ret = 0;
	for (Path<V> path : this.minPath(a, b))
	    ret = path.weight;
	return ret;

    }

    public void disegnaGrafo() {
	int i, j;
	i = 0;
	for (Vertex<V> vert : this.vertex.values()) {
	    System.out.println("Nodo " + (i++) + ": " + vert.getValue());
	    j = 0;
	    for (Edge<V> edge : vert.getNeightbor().values())
		System.out.println(
			"\tNodo vicino " + (j++) + ": " + edge.vertex.getValue() + ",\t distanza: " + edge.weight);
	}
    }
}
