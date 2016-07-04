package esercizio3;

public class Edge {

    private Node linkedTo;
    private double edgeValue;

    public Edge() {
	this.linkedTo = null;
	this.edgeValue = 0;
    }

    public Edge(Node node, double edge) {
	this.linkedTo = node;
	this.edgeValue = edge;
    }

    public Edge(String city, double edge) {
	this.linkedTo = new Node(city);
	this.edgeValue = edge;
    }

    public Node getLinkedTo() {
	return this.linkedTo;
    }

    public double getEdgeValue() {
	return this.edgeValue;
    }

    public void setLinkedTo(Node linkedTo) {
	this.linkedTo = linkedTo;
    }

    public void setlinkedTo(String to) {
	this.linkedTo = new Node(to);
    }

    public void setArcEdge(double value) {
	this.edgeValue = value;
    }

    @Override
    public String toString() {
	return this.linkedTo + " " + this.edgeValue;
    }
}