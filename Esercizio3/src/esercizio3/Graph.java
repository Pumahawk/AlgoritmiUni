package esercizio3;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {

    public static void Dykstra(ArrayList<Node> list, Node source) {
	for (Node node : list) {
	    node.setDistance(Double.POSITIVE_INFINITY);
	    node.setPrevious(null);
	}
	PriorityQueue nodeQueue = new PriorityQueue();
	source.setDistance(0f);
	nodeQueue.add(source);
	while (!nodeQueue.isEmpty()) {
	    Node u = nodeQueue.removeMin();
	    if (u.getDistance() == Double.POSITIVE_INFINITY) {
		System.out.println("errore");
		break;
	    }

	    for (int i = 0; i < u.getAdjacents().size(); i++) {
		Edge e = u.getAdjacents().get(i);
		Node v = e.getLinkedTo();

		double weight = e.getEdgeValue();
		double distanceThroughU = u.getDistance() + weight;
		if (distanceThroughU < v.getDistance()) {
		    nodeQueue.remove(v);

		    v.setDistance(distanceThroughU);
		    v.setPrevious(u);
		    nodeQueue.add(v);
		}
	    }
	} // end while

    }// end Dykstra

    public static ArrayList<Node> getShortestPathTo(ArrayList<Node> list, Node source, Node destination) {
	Dykstra(list, source);
	int totalDistance = 0;
	ArrayList<Node> path = new ArrayList<Node>();
	for (Node node = destination; node != null; node = node.getPrevious()) {
	    path.add(node);
	}

	Collections.reverse(path);
	return path;
    }

}// end class
