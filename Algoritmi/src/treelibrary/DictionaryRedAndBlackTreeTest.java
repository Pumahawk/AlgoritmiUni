package treelibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class DictionaryRedAndBlackTreeTest {

    @Test
    public void testRemoveRoot() {
	DRBTree<Integer, String> rbt = new DRBTree<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");
	rbt.remove(5);

	assertEquals(rbt.get(5) == null, true);
    }

    @Test
    public void testRemoveRootOneLeftChild() {
	DRBTree<Integer, String> rbt = new DRBTree<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");
	rbt.remove(4);

	assertEquals(rbt.get(4) == null, true);
    }

    @Test
    public void testRemoveRootOneRightChild() {
	DRBTree<Integer, String> rbt = new DRBTree<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");
	rbt.remove(6);

	assertEquals(rbt.get(6) == null, true);
    }

    @Test
    public void testRemoveRootTwoChild() {
	DRBTree<Integer, String> rbt = new DRBTree<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");
	rbt.remove(4);
	rbt.remove(6);

	assertEquals(rbt.get(4) == null && rbt.get(6) == null, true);
    }

    @Test
    public void testInsertT() {
	DRBTree<Integer, String> rbt = new DRBTree<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));

	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");

	assertEquals(rbt.get(4) == "Test1", true);
	assertEquals(rbt.get(5) == "Test2", true);
	assertEquals(rbt.get(6) == "Test3", true);

    }

    @Test
    public void testSearchFound() {
	DRBTree<Integer, String> rbt = new DRBTree<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));

	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");

	assertEquals(rbt.get(4) == "Test1", true);

    }
}
