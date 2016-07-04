package esercizio3;

import java.util.ArrayList;

public class PriorityQueue {

    private ArrayList<Node> list;

    public PriorityQueue() {
	list = new ArrayList<Node>();
    }

    public ArrayList<Node> getList() {
	return list;
    }

    public void setList(ArrayList<Node> list) {
	this.list = list;
    }

    public void add(Node node) {
	this.list.add(node);
    }

    public Node findMin() {
	if (list.size() == 0)
	    return null;
	Node temp = list.get(0);
	for (int i = 1; i < list.size(); i++) {
	    if (list.get(i).getDistance() < temp.getDistance()) {
		temp = list.get(i);
	    }
	}
	return temp;
    }

    public Node removeMin() {
	Node node = findMin();
	if (node != null) {
	    list.remove(node);
	    return node;
	}
	return null;

    }

    public boolean isEmpty() {
	return (list.size() == 0);

    }

    public void remove(Node node) {
	if (node != null)
	    list.remove(node);
    }
}
