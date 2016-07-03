package esercizio3;

import java.util.ArrayList;

public class Node {

    private String city;
    private Node previous;
    private double distance;
    private ArrayList<Edge> adjacents;

    public Node(String city) {
	this.city = city;
	this.previous = null;
	this.distance = Double.POSITIVE_INFINITY;
	this.adjacents = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getAdjacents() {
	return this.adjacents;
    }

    public void setAdjacents(ArrayList<Edge> adj) {
	this.adjacents = adj;
    }

    public Node(String city, Node previous, int distance) {
	this.city = city;
	this.previous = previous;
	this.distance = distance;
    }

    public String getCity() {
	return this.city;
    }

    public double getDistance() {
	return this.distance;
    }

    public Node getPrevious() {
	return this.previous;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public void setDistance(double distance) {
	this.distance = distance;
    }

    public void setPrevious(Node previous) {
	this.previous = previous;
    }

    public int compareTo(Node node) {
	return this.city.compareTo(node.city);
    }

    @Override
    public String toString() {
	return this.city;
    }
}// end class
