package dimN;

import org.junit.Test;

public class TestNormalTree {

    @Test
    public void testRemove() {
	NormalTree<Integer> tree = generateTestTree();
	tree.remove(70);
    }

    public NormalTree<Integer> generateTestTree() {
	NormalTree<Integer> tree = new NormalTree<Integer>((Integer a, Integer b) -> a.compareTo(b));
	tree.put(100);
	tree.put(70);
	tree.put(120);
	tree.put(90);
	tree.put(60);
	return tree;
    }
}
