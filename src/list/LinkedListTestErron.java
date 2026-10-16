
package list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class LinkedListTestErron {

    @Test
    void testEmptyList() {
        LinkedList<String> list = new LinkedList<>();

        assertEquals(0, list.size());
        assertFalse(list.contains("apple"));
        assertNull(list.peek());
        assertNull(list.peekFirst());
        assertNull(list.peekLast());
        assertNull(list.poll());
        assertNull(list.pollFirst());
        assertNull(list.pollLast());
        assertEquals(-1, list.indexOf("apple"));
        assertEquals(-1, list.lastIndexOf("apple"));
        assertArrayEquals(new Object[0], list.toArray());
    }

    @Test
    void testFirstAndLast() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");

        assertEquals(3, list.size());
        assertEquals("A", list.getFirst());
        assertEquals("C", list.getLast());
        assertEquals("A", list.peekFirst());
        assertEquals("C", list.peekLast());
    }

    @Test
    void testGetFirstAndLastOnEmptyList() {
        LinkedList<String> list = new LinkedList<>();

        assertThrows(NoSuchElementException.class,
                () -> list.getFirst());
        assertThrows(NoSuchElementException.class,
                () -> list.getLast());
        assertThrows(NoSuchElementException.class,
                () -> list.removeFirst());
        assertThrows(NoSuchElementException.class,
                () -> list.removeLast());
        assertThrows(NoSuchElementException.class,
                () -> list.element());
        assertThrows(NoSuchElementException.class,
                () -> list.remove());
        assertThrows(NoSuchElementException.class,
                () -> list.pop());
    }

    @Test
    void testAddAndRemove() {
        LinkedList<String> list = new LinkedList<>();

        assertTrue(list.add("A"));
        assertTrue(list.offer("B"));
        assertTrue(list.offerFirst("C"));
        assertTrue(list.offerLast("D"));

        assertEquals("C", list.removeFirst());
        assertEquals("D", list.removeLast());
        assertEquals("A", list.remove());
        assertEquals("B", list.pop());
        assertEquals(0, list.size());
    }

    @Test
    void testContainsAndRemoveObjects() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("A");

        assertTrue(list.contains("A"));
        assertFalse(list.contains("Z"));
        assertTrue(list.remove("A"));
        assertEquals(2, list.size());
        assertTrue(list.removeFirstOccurrence("A"));
        assertFalse(list.removeLastOccurrence("A"));
        assertFalse(list.remove("Z"));
    }

    @Test
    void testNullElements() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add(null);
        list.add(null);

        assertTrue(list.contains(null));
        assertEquals(1, list.indexOf(null));
        assertEquals(2, list.lastIndexOf(null));
        assertTrue(list.remove(null));
        assertTrue(list.removeLastOccurrence(null));
        assertFalse(list.remove(null));
        assertEquals(1, list.size());
    }

    @Test
    void testAddAll() {
        LinkedList<String> source = new LinkedList<>();
        source.add("B");
        source.add("C");

        LinkedList<String> list = new LinkedList<>();
        list.add("A");

        assertTrue(list.addAll(source));
        assertArrayEquals(
                new Object[]{"A", "B", "C"}, list.toArray());

        LinkedList<String> middle = new LinkedList<>();
        middle.add("X");
        middle.add("Y");

        assertTrue(list.addAll(1, middle));
        assertArrayEquals(
                new Object[]{"A", "X", "Y", "B", "C"},
                list.toArray());

        assertFalse(list.addAll(new LinkedList<>()));
        assertFalse(list.addAll(2, new LinkedList<>()));
    }

    @Test
    void testAddAllInvalidIndexes() {
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> source = new LinkedList<>();
        source.add("A");

        assertThrows(IndexOutOfBoundsException.class,
                () -> list.addAll(-1, source));
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.addAll(1, source));
    }

    @Test
    void testIndexedOperations() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));

        assertEquals("B", list.set(1, "X"));
        assertEquals("X", list.get(1));

        assertEquals("X", list.remove(1));
        assertArrayEquals(
                new Object[]{"A", "C"}, list.toArray());
    }

    @Test
    void testInvalidIndexes() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");

        assertThrows(IndexOutOfBoundsException.class,
                () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.set(1, "B"));
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.add(2, "B"));
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.remove(1));
    }

    @Test
    void testIndexSearches() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("A");

        assertEquals(0, list.indexOf("A"));
        assertEquals(2, list.lastIndexOf("A"));
        assertEquals(1, list.indexOf("B"));
        assertEquals(1, list.lastIndexOf("B"));
        assertEquals(-1, list.indexOf("Z"));
        assertEquals(-1, list.lastIndexOf("Z"));
    }

    @Test
    void testQueueOperations() {
        LinkedList<String> list = new LinkedList<>();
        list.offer("A");
        list.offer("B");

        assertEquals("A", list.element());
        assertEquals("A", list.peek());
        assertEquals("A", list.poll());
        assertEquals("B", list.poll());
        assertNull(list.poll());
    }

    @Test
    void testDequeAndStackOperations() {
        LinkedList<String> list = new LinkedList<>();

        list.push("A");
        list.push("B");
        assertEquals("B", list.pop());
        assertEquals("A", list.pop());

        list.add("B");
        list.add("C");
        assertEquals("C", list.pollLast());
        assertEquals("B", list.pollFirst());

        assertNull(list.pollFirst());
        assertNull(list.pollLast());
    }

    @Test
    void testLastOccurrence() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("A");

        assertTrue(list.removeLastOccurrence("A"));
        assertArrayEquals(
                new Object[]{"A", "B"}, list.toArray());

        assertTrue(list.removeFirstOccurrence("A"));
        assertFalse(list.removeFirstOccurrence("Z"));
        assertFalse(list.removeLastOccurrence("Z"));
    }

    @Test
    void testClear() {
        LinkedList<String> list = new LinkedList<>();
        list.clear();

        list.add("A");
        list.add("B");
        list.clear();

        assertEquals(0, list.size());
        assertArrayEquals(new Object[0], list.toArray());
    }

    @Test
    void testCopyConstructor() {
        LinkedList<String> original = new LinkedList<>();
        original.add("A");
        original.add("B");

        LinkedList<String> copy = new LinkedList<>(original);

        assertArrayEquals(original.toArray(), copy.toArray());

        copy.add("C");
        assertEquals(2, original.size());
        assertEquals(3, copy.size());
    }

    @Test
    void testArrayConversions() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");

        String[] small = list.toArray(new String[0]);
        assertArrayEquals(new String[]{"A", "B"}, small);

        String[] large = new String[]{"X", "Y", "Z", "W"};
        String[] result = list.toArray(large);

        assertSame(large, result);
        assertArrayEquals(
                new String[]{"A", "B", null, "W"}, result);
    }

    @Test
    void testTypedArrayWithExactSize() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");

        String[] array = new String[]{"X", "Y"};
        assertSame(array, list.toArray(array));
        assertArrayEquals(new String[]{"A", "B"}, array);
    }
}

