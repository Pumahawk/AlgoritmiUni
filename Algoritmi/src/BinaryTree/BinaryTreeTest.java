package BinaryTree;

import java.util.Comparator;

public class BinaryTreeTest {
    private static class IntegerComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
	    return i1.compareTo(i2);
	}
    }

    /*
     * @Test public void test() { fail("Not yet implemented"); }
     */
    public static void main(String[] args) {
	BinaryTree<Integer, String> binTree = new BinaryTree(new IntegerComparator());
	binTree.put(3, "Lollo");
	binTree.put(1, "Oussama");
	binTree.put(2, "L'innominato");
	binTree.put(4, "Lollo2");
	binTree.put(7, "Lollo3");

	// binTree.stampa();

	// System.out.println(binTree.size());

	// binTree.put(7, "Lollo4 il ritorno la vendetta");

	binTree.stampa();

	// System.out.println(binTree.size());

	System.out.println(binTree.ricercaInProfonditaIn(3, binTree));
	System.out.println(binTree.ricercaInProfonditaIn(3, binTree));

    }

}
