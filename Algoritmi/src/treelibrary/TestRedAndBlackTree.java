package treelibrary;

import org.junit.Test;

class TestRedAndBlackTree {

    public RBTree<Integer> getTreeForTest() {
	RBTree<Integer> tree = new RBTree<Integer>((Integer a, Integer b) -> a.compareTo(b));

	for (int i = 0; i < 5; i++)
	    tree.put(i);
	return tree;
    }

    @Test
    public void testRemove() {
	RBTree<Integer> tree = getTreeForTest();
	tree.remove(3);
	return;
    }

}
