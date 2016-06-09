package Graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph<V> {

    private class Tag {
	public Vertex<V> vertex;
	public int weight;
	public Vertex<V> before;

	public Tag(Vertex<V> vertex, int weight, Vertex<V> before) {
	    this.vertex = vertex;
	    this.weight = weight;
	    this.before = before;
	}

	public Tag(Vertex<V> vertex) {
	    this(vertex, -1, null);
	}
    }

    private HashMap<V, Vertex<V>> vertex;

    public Graph() {
	this.vertex = new HashMap<>();
    }

    public void addVertex(V vertex) {
	this.vertex.put(vertex, new Vertex<V>(vertex));
    }

    public boolean containsVertex(V vertex) {
	return this.vertex.containsKey(vertex);
    }

    public void link(V a, V b, int weight) {
	this.vertex.get(a).setNeigthBor(this.vertex.get(b), weight);
    }

    public LinkedList<V> minPath(V a, V b) {
	HashMap<Vertex<V>, Tag> visitati = new HashMap<>();
	HashMap<Vertex<V>, Tag> daVisitare = new HashMap<>();

	daVisitare.put(this.vertex.get(a), new Tag(this.vertex.get(a), 0, null));
	while (daVisitare.size() != 0) {
	    Tag minTag = minTag(daVisitare);
	    for (Vertex<V>.Edge edge : minTag.vertex.getNeightbor().values())
		if (daVisitare.containsKey(edge.vertex)) {
		    if (daVisitare.get(edge.vertex).weight > minTag.weight + edge.weight) {
			daVisitare.get(edge.vertex).before = minTag.vertex;
			daVisitare.get(edge.vertex).weight = minTag.weight + edge.weight;
		    }
		} else if (!visitati.containsKey(edge.vertex))
		    daVisitare.put(edge.vertex, new Tag(edge.vertex, minTag.weight + edge.weight, minTag.vertex));
	    daVisitare.remove(minTag.vertex);
	    visitati.put(minTag.vertex, minTag);
	}
	LinkedList<V> ret = new LinkedList<>();
	visitati.get(this.vertex.get(b));
	Tag tagList = visitati.get(this.vertex.get(b));
	while (tagList != null) {
	    ret.add(tagList.vertex.getValue());
	    tagList = visitati.get(tagList.before);
	}
	return ret;
    }

    public Tag minTag(HashMap<Vertex<V>, Tag> tagList) {
	Tag min = null;
	for (Tag tag : tagList.values()) {
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

	System.out.println("---------------");
	citta.stampaPercorso("torino", "milano");
	System.out.println("---------------");

	System.out.println("---------------");
	citta.stampaPercorso("torino", "vercelli");
	System.out.println("---------------");

	System.out.println("---------------");
	citta.stampaPercorso("vercelli", "cuneo");
	System.out.println("---------------");
	System.out.println("Fine");
    }

    public void stampaPercorso(V a, V b) {
	System.out.println(a + " + " + b);
	for (V nome : this.minPath(a, b))
	    System.out.println(nome);
    }
}
