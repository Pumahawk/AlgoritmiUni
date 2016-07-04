package dimN;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DictionaryRedAndBlackTreeTest {

    @Test
    public void testRemoveRoot() {
	DictionaryRedAndBlackTree<Integer, String> rbt = new DictionaryRedAndBlackTree<Integer, String>(
		(Integer a, Integer b) -> a.compareTo(b));
	rbt.put(4, "Test1");
	rbt.put(5, "Test2");
	rbt.put(6, "Test3");
	rbt.remove(5);
	System.out.println(rbt.remove(4));

	assertEquals(rbt.get(4) == null, true);
    }
}
