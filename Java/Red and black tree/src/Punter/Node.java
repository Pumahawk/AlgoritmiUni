package Punter;

public class Node<T> implements Pointer {
    public T value;
    public Pointer pointer;
    
    public Node(T val, Pointer p){
	this.value = val;
	this.pointer = p;
    }
    @Override
    public Pointer getPointer() {
	return pointer;
    }
}
