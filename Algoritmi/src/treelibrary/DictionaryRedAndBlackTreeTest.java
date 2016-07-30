package treelibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class DictionaryRedAndBlackTreeTest {

    @Test
    public void testRemoveRoot() {
	DictionaryTreeRB<Integer, String> rbt = new DictionaryTreeRB<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");
	rbt.remove(5);

	assertEquals(rbt.get(5) == null, true);
    }

    @Test
    public void testRemoveRootOneLeftChild() {
	DictionaryTreeRB<Integer, String> rbt = new DictionaryTreeRB<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");
	rbt.remove(4);

	assertEquals(rbt.get(4) == null, true);
    }

    @Test
    public void testRemoveRootOneRightChild() {
	DictionaryTreeRB<Integer, String> rbt = new DictionaryTreeRB<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");
	rbt.remove(6);

	assertEquals(rbt.get(6) == null, true);
    }

    @Test
    public void testRemoveRootTwoChild() {
	DictionaryTreeRB<Integer, String> rbt = new DictionaryTreeRB<Integer, String>(
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
	DictionaryTreeRB<Integer, String> rbt = new DictionaryTreeRB<Integer, String>(
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
	DictionaryTreeRB<Integer, String> rbt = new DictionaryTreeRB<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));

	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");

	assertEquals(rbt.get(4) == "Test1", true);

    }
}
