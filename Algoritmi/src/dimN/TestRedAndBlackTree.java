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

	for (int i = 0; i < 10000; i++)
	    tree.put(i);
	return tree;
    }

}
