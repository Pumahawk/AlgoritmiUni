package dimN;

import org.junit.Test;

public class TestRedAndBlackTree {

    @Test
    public void testPut() {
	RedAndBlackTree<Integer> tree = getTreeForTest();
	return;
    }

    public RedAndBlackTree<Integer> getTreeForTest() {
	RedAndBlackTree<Integer> tree = new RedAndBlackTree<Integer>((Integer a, Integer b) -> a.compareTo(b));

	for (int i = 0; i < 5; i++)
	    tree.put(i);
	return tree;
    }

    @Test
    public void testRemove() {
	RedAndBlackTree<Integer> tree = getTreeForTest();
	tree.remove(3);
	return;
    }

}