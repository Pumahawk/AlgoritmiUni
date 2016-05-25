package Graphs;

public interface GraphSearch<V, E> {

    // metodo per la ricerca all'interno di un grafo. Gli passo il grafo sulla
    // quale cercare e il vertice di inizio, cioè la "root"

    boolean search(Graph graph, V initVertex);
}
