package dimN;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Ordinamento.QuickSortTest.IntegerComparator;

public class RedBlackTreeTest {
    RedBlackNode<K, R> nil = new RedBlackNode<K, R>();

    @Test
    public void testRemoveRoot() {
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(new IntegerComparator());
	rbt.insert(new RedBlackNode<K, R>(new K(null, 11, null), new R(null, 11, null)));
	rbt.remove(new K(null, 11, null));

	assertEquals((rbt.root.key == null && rbt.root.value == null), true);
    }

    @Test
    public void testRemoveRootOneLeftChild() {
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(new IntegerComparator());
	IntegerComparator comp = new IntegerComparator();
	rbt.insert(new RedBlackNode<K, R>(new K(null, 11, null), new R(null, 11, null)));
	rbt.insert(new RedBlackNode<K, R>(new K(null, 10, null), new R(null, 10, null)));
	rbt.remove(new K(null, 11, null));
	assertEquals(comp.compare(rbt.root.key, new K(null, 10, null)), 0);

    }

    @Test
    public void testRemoveRootOneRightChild() {
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(new IntegerComparator());
	IntegerComparator comp = new IntegerComparator();
	rbt.insert(new RedBlackNode<K, R>(new K(null, 11, null), new R(null, 11, null)));
	rbt.insert(new RedBlackNode<K, R>(new K(null, 12, null), new R(null, 12, null)));
	rbt.remove(new K(null, 11, null));

	assertEquals(comp.compare(rbt.root.key, new K(null, 12, null)), 0);

    }

    @Test
    public void testRemoveRootTwoChild() {
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(new IntegerComparator());
	IntegerComparator comp = new IntegerComparator();
	rbt.insert(new RedBlackNode<K, R>(new K(null, 11, null), new R(null, 11, null)));
	rbt.insert(new RedBlackNode<K, R>(new K(null, 10, null), new R(null, 10, null)));
	rbt.insert(new RedBlackNode<K, R>(new K(null, 12, null), new R(null, 12, null)));

	rbt.remove(new K(null, 11, null));
	assertEquals(comp.compare(rbt.root.key, new K(null, 12, null)), 0);

    }

    @Test
    public void testRemoveOneElementFromFullTree() throws NullPointerException {
	int k = 10;
	IntegerComparator compi = new IntegerComparator();
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(compi);

	for (int i = 0; i < 10; i++) {
	    K e = new K(null, k++, null);
	    rbt.insert(new RedBlackNode<K, R>(e, new R(null, i, null)));
	}
	rbt.remove(new K(null, 10, null));

	assertEquals(rbt.search(new K(null, 10, null)), false);

    }

    @Test
    public void testRemoveMoreElementFromFullTree() throws NullPointerException {
	int k = 10;
	IntegerComparator compi = new IntegerComparator();
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(compi);

	for (int i = 0; i < 10; i++) {
	    K e = new K(null, k++, null);
	    rbt.insert(new RedBlackNode<K, R>(e, new R(null, i, null)));
	}
	// System.out.println("root"+ rbt.root.key);
	rbt.remove(new K(null, 13, null));

	assertEquals(rbt.search(new K(null, 13, null)), false);

    }

    @Test
    public void testInsertT() {
	int k = 10;
	IntegerComparator compi = new IntegerComparator();
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(compi);

	for (int i = 0; i < 10; i++) {
	    K e = new K(null, k++, null);
	    rbt.insert(new RedBlackNode<K, R>(e, new R(null, i, null)));

	}

	// System.out.println(rbt.root.toString());
	// print(rbt.root);

    }

    @Test
    public void testSearchFound() {
	int k = 10;
	IntegerComparator compi = new IntegerComparator();
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(compi);

	for (int i = 0; i < 20; i++) {
	    K e = new K(null, k++, null);
	    rbt.insert(new RedBlackNode<K, R>(e, new R(null, i, null)));

	}
	assertTrue(rbt.search(new K(null, 16, null)));

    }

    @Test
    public void testSearchNotFound() {
	int k = 10;
	IntegerComparator compi = new IntegerComparator();
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(compi);

	for (int i = 0; i < 20; i++) {
	    K e = new K(null, k++, null);
	    rbt.insert(new RedBlackNode<K, R>(e, new R(null, i, null)));

	}
	assertEquals(rbt.search(new K(null, 45, null)), false);

    }

    @Test
    public void testOrderedInsert() {
	IntegerComparator compi = new IntegerComparator();
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(compi);
	int k = 0;
	for (int i = 0; i < 100; i++) {
	    K e = new K(null, k++, null);
	    rbt.insert(new RedBlackNode<K, R>(e, new R(null, k++, null)));

	}
	assertTrue(rbt.height() < 10);
    }

    @Test
    public void testRBProperties() {
	IntegerComparator compi = new IntegerComparator();
	RedBlackTree<K, R> rbt = new RedBlackTree<K, R>(compi);
	int k = 0;
	for (int i = 0; i < 100; i++) {
	    K e = new K(null, k++, null);
	    rbt.insert(new RedBlackNode<K, R>(e, new R(null, k++, null)));

	}
	assertTrue(rbt.checkColors());
    }
}
