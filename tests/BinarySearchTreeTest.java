
import dataStructures.BinarySearchTree;
import dataStructures.Entry;
import dataStructures.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
        assertTrue(bst.isEmpty());
    }

    @Test
    public void testInsert() {
        assertNull(bst.insert(8, "1"));//We see this tree on the Wikipedia as an example of a bst
        assertNull(bst.insert(3, "2"));//We will use it to test our insert function since we
        assertNull(bst.insert(1, "3"));//know how the traversal at the end should work. There
        assertNull(bst.insert(6, "4"));//are other ways to do this, however, this structure should
        assertNull(bst.insert(4, "5"));//provide us not only with a series of inserts that will hit
        assertNull(bst.insert(7, "6"));//every line of code in the insert method and produce results
        assertNull(bst.insert(10, "7"));//that we can expect
        assertNull(bst.insert(14, "8"));
        assertNull(bst.insert(13, "9"));
        assertEquals("9", bst.insert(13, "10"));//Handle inserting an element that already exists


        Iterator<Entry<Integer, String>> it = bst.iterator();
        assertTrue(it.hasNext());
        Entry<Integer, String> entry;

        entry = it.next();
        assertEquals(1, entry.getKey());
        assertEquals("3", entry.getValue());

        entry = it.next();
        assertEquals(3, entry.getKey());
        assertEquals("2", entry.getValue());

        entry = it.next();
        assertEquals(4, entry.getKey());
        assertEquals("5", entry.getValue());

        entry = it.next();
        assertEquals(6, entry.getKey());
        assertEquals("4", entry.getValue());

        entry = it.next();
        assertEquals(7, entry.getKey());
        assertEquals("6", entry.getValue());

        entry = it.next();
        assertEquals(8, entry.getKey());
        assertEquals("1", entry.getValue());

        entry = it.next();
        assertEquals(10, entry.getKey());
        assertEquals("7", entry.getValue());

        entry = it.next();
        assertEquals(13, entry.getKey());
        assertEquals("10", entry.getValue());

        entry = it.next();
        assertEquals(14, entry.getKey());
        assertEquals("8", entry.getValue());

        assertFalse(it.hasNext());
    }

    @Test
    public void testRemove() {
        assertNull(bst.remove(1));//deleting on an empty tree
        for (int i = 10; i < 20; i++) {
            assertNull(bst.insert(i, String.format("%d", i)));
        }
        for (int k = 9; k > -1; k--) {
            assertNull(bst.insert(k, String.format("%d", k)));
        }

        for (int j = 0; j < 10; j++) {
            assertEquals(String.format("%d", j), bst.remove(j));//Test basic delete functionality
        }

        Iterator<Entry<Integer, String>> it = bst.iterator();
        assertTrue(it.hasNext());
        int i = 10;
        while (it.hasNext()) {
            Entry<Integer, String> entry = it.next();
            assertEquals(i, entry.getKey());
            assertEquals(String.format("%d", i), entry.getValue());
            i++;
        }
        assertFalse(it.hasNext());

        for (int l = 19; l > 9; l--) {
            assertEquals(String.format("%d", l), bst.remove(l));
        }
        assertTrue(bst.isEmpty());

        assertNull(bst.insert(10, "10"));//Handle the edge cases of deletion
        assertNull(bst.insert(8, "8"));//Deleting a  leaf
        assertNull(bst.insert(9, "9"));
        assertNull(bst.insert(6, "6"));
        assertNull(bst.insert(7, "7"));
        assertEquals("6", bst.remove(6));

        it = bst.iterator();
        assertTrue(it.hasNext());
        i = 7;
        while (it.hasNext()) {
            Entry<Integer, String> entry = it.next();
            assertEquals(i, entry.getKey());
            assertEquals(String.format("%d", i), entry.getValue());
            i++;
        }
        assertFalse(it.hasNext());

        assertNull(bst.insert(6, "6"));//Deleting an internal node
        assertEquals("7", bst.remove(7));

        it = bst.iterator();
        assertTrue(it.hasNext());

        Entry<Integer, String> entry = it.next();
        assertEquals(6, entry.getKey());
        assertEquals("6", entry.getValue());

        entry = it.next();
        assertEquals(8, entry.getKey());
        assertEquals("8", entry.getValue());

        entry = it.next();
        assertEquals(9, entry.getKey());
        assertEquals("9", entry.getValue());

        entry = it.next();
        assertEquals(10, entry.getKey());
        assertEquals("10", entry.getValue());

        assertFalse(it.hasNext());

        bst = new BinarySearchTree<>();
        assertTrue(bst.isEmpty());

        assertNull(bst.insert(10, "10"));//Deleting an internal node and pushing
        assertNull(bst.insert(8, "8"));//the new node up
        assertNull(bst.insert(9, "9"));
        assertNull(bst.insert(7, "7"));
        assertEquals("8", bst.remove(8));

        it = bst.iterator();
        assertTrue(it.hasNext());

        entry = it.next();
        assertEquals(7, entry.getKey());
        assertEquals("7", entry.getValue());

        entry = it.next();
        assertEquals(9, entry.getKey());
        assertEquals("9", entry.getValue());

        entry = it.next();
        assertEquals(10, entry.getKey());
        assertEquals("10", entry.getValue());

        assertFalse(it.hasNext());

        bst = new BinarySearchTree<>();
        assertTrue(bst.isEmpty());
        assertNull(bst.insert(10, "10"));//Deleting an internal node and progressing
        assertNull(bst.insert(8, "8"));//down the left subtree to the rightmost
        assertNull(bst.insert(9, "9"));//node found in it.
        assertNull(bst.insert(6, "6"));
        assertNull(bst.insert(7, "7"));
        assertEquals("8", bst.remove(8));

        it = bst.iterator();
        assertTrue(it.hasNext());

        entry = it.next();
        assertEquals(6, entry.getKey());
        assertEquals("6", entry.getValue());

        entry = it.next();
        assertEquals(7, entry.getKey());
        assertEquals("7", entry.getValue());

        entry = it.next();
        assertEquals(9, entry.getKey());
        assertEquals("9", entry.getValue());

        entry = it.next();
        assertEquals(10, entry.getKey());
        assertEquals("10", entry.getValue());

        assertFalse(it.hasNext());

        bst = new BinarySearchTree<>();
        for(i = 1; i <= 5; i++)
            assertNull(bst.insert(i,""));

    }
}