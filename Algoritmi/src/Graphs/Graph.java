package Graphs;

import java.util.Collection;

public interface Graph<V, E> {

    boolean addVertex(V vertex);

    boolean addEdge(E edge);

    boolean hasVertex(V vertex);

    boolean hasEdge(V vertex1, V vertex2);

    // Restituisce il dato associato all'arco vertex1 --> vertex2

    E getData(V vertex1, V vertex2);

    Collection<V> getVertices();

    // Restituisce i vertici vicini al vertice vertex. Neighbors(significa
    // vicini)

    Collection<V> getNeighbors(V vertex);
}
