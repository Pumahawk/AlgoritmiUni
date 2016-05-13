package Punter;

public class NodeTree<T> implements Pointer {
    protected T value;
    protected Pointer leftPointer;
    public Pointer rightPointer;
    
    public NodeTree(T v, Pointer l, Pointer r){
	this.value = v;
	this.leftPointer = l;
	this.rightPointer = r;
    }
    
    public NodeTree(T v){
	this(v, null, null);
    }

    @Override
    public Pointer getPointer() {
	return (leftPointer != null) ? leftPointer : rightPointer;
    }
    
    public Pointer leftPointer(){
	return leftPointer;
    }
    
    public Pointer rightPointer(){
	return rightPointer;
    }

}
