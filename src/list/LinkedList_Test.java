package list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class LinkedList_Test {
	@Test
	void testConstructor() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		LinkedList<Integer> copy = new LinkedList<>(list);
		assertEquals(1, copy.size());
		
	}

	@Test
	void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }
	@Test
    void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }
	@Test
    void testGetFirstAndLast() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
        assertThrows(NoSuchElementException.class, () -> list.getLast());
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.getFirst());
        assertEquals(3, list.getLast());
    }
	@Test
    void testRemoveFirstAndLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.size());
        assertEquals(3, list.removeLast());
        assertEquals(1, list.size());
    }   
	
	@Test
	void testAddFirst() {
		LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
	}

}
