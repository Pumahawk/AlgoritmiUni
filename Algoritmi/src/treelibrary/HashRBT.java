package treelibrary;

public class HashRBT<V> extends RBTree<V> {

    public HashRBT() {
	super((V a, V b) -> comparator(a.hashCode(), b.hashCode()));
    }

    private static int comparator(int a, int b) {
	return (a == b) ? 0 : (a < b) ? -1 : 1;
    }

}
