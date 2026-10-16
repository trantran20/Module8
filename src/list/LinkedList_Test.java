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
	void testAddFirstAndAddLast() {
		 LinkedList<Integer> list = new LinkedList<>();
	        list.addFirst(1);
	        list.addLast(2);
	        list.addFirst(0);
	        assertEquals(3, list.size());
	        assertEquals(0, list.getFirst());
	        assertEquals(2, list.getLast());
	        
	}
	
	@Test
	 void containsTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(true, list.contains(2));
        assertEquals(false, list.contains(4));
    }
	 @Test 
	    void removeNullTest() {
		 LinkedList<Integer> list = new LinkedList<>();
	     list.add(1);
	     list.add(null);
	     assertEquals(true, list.remove(null));
	     assertEquals(false, list.contains(null));
	    }   
	 
	 @Test
	 void removeNotNull() {
		 LinkedList<Integer> list = new LinkedList<>();
		 list.add(1);
		 assertEquals(false, list.remove(null));
	 }
	 
	 @Test 
	 void removeObject() {
		 LinkedList<String> list = new LinkedList<>();
		 assertThrows(NoSuchElementException.class, () -> list.remove());
		 list.add("A");
		 list.add("B");
		 assertEquals(true, list.remove("A"));
		 
	 }
	 
	 @Test
	 void removeObjectNotFound() {
		 LinkedList<String> list = new LinkedList<>();
		 list.add("A");
		 assertEquals(false, list.remove("B"));
		 
	 }
	 
	 @Test
	 void testAddAllNegativeIndex() {
		 LinkedList<String> list = new LinkedList<>();
		 LinkedList<String> other = new LinkedList<>();
		 other.add("A");
		 assertThrows(IndexOutOfBoundsException.class, () -> list.addAll(-1,other));
		 assertThrows(IndexOutOfBoundsException.class, () -> list.addAll(1,other));
		 
	 }
	 
	 @Test
	 void testAddAllLength0() {
		 LinkedList<String> list = new LinkedList<>();
		 LinkedList<String> other = new LinkedList<>();
		 assertEquals(false, list.addAll(0,other));
	 }
	 
	 @Test
	 void testAddAll() {
		 LinkedList<String> list = new LinkedList<>();
		 list.add("A");
		 LinkedList<String> other = new LinkedList<>();
		 other.add("B");
		 
		 assertEquals(true, list.addAll(1,other));
		 assertEquals(2, list.size());
		 assertEquals(true, list.addAll(0,other));
	 }
	 
	 @Test
	 void clearTest() {
		 LinkedList<String> list = new LinkedList<>();
		 list.add("A");
		 list.add("B");
		 
		 list.clear();
		 
		 assertEquals(0, list.size());
	 }
	 
	 @Test
	 void setTest() {
		 LinkedList<String> list = new LinkedList<>();
		 list.add("A");
		 list.add("B");
		 assertEquals("A", list.set(0, "C"));
		 
	 }
	 
	 @Test
	 void addTest() {
		 LinkedList<String> list = new LinkedList<>();
		 list.add("A");
		 list.add("B");
		 list.add(2, "C");
		 assertEquals("C", list.get(2));
		 list.add(0,"D");
		 assertEquals("D", list.get(0));
	 }
	 
	 @Test
	 void entryTest() {
		 LinkedList<String> list = new LinkedList<>();
		 list.add("A");
		 list.add("B");
		 assertEquals("A", list.get(0));
		 assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
		 assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
	 }
	 
	 @Test
	 void indexOfTest() {
		 LinkedList<String> list = new LinkedList<>();
		 list.add("A");
		 list.add(null);
		 assertEquals(1, list.indexOf(null));
	 }
	 
	 @Test
	 void lastIndexOfTest() {
		 LinkedList<String> list = new LinkedList<>();
		 assertEquals(-1, list.lastIndexOf("C"));
		 assertEquals(-1, list.lastIndexOf(null));
		 list.add("A");
		 list.add("B");
		 list.add("A");
		 assertEquals(-1, list.lastIndexOf(null));
		 assertEquals(1, list.lastIndexOf("B"));
		 assertEquals(2, list.lastIndexOf("A"));
		 assertEquals(-1, list.lastIndexOf("C"));
		 list.add(null);
		 assertEquals(3, list.lastIndexOf(null));
		 
	 }
	 
	 @Test
	 void peakPullElementPollRemoveOfferOfferFirst() {
		 LinkedList<String> list = new LinkedList<>();
		 assertEquals(null, list.peek());
		 assertEquals(null, list.poll());
		 assertEquals(null, list.pollFirst());
		 assertEquals(null, list.pollLast());
		 assertEquals(null, list.peekFirst());
		 assertEquals(null, list.peekLast());
		 list.add("A");
		 list.add("B");
		 assertEquals("A", list.peek());
		 assertEquals("A", list.element());
		 assertEquals("A", list.poll());
		 assertEquals("B", list.remove());
		 assertEquals(true, list.offer("C"));
		 assertEquals(true, list.offerFirst("D"));
		 assertEquals(true, list.offerLast("E"));
		 assertEquals("D", list.peekFirst());
		 assertEquals("E", list.peekLast());
		 assertEquals("D", list.pollFirst());
		 assertEquals("E", list.pollLast());
		 list.push("A");
		 assertEquals("A", list.getFirst());
		 assertEquals("A", list.pop());
		 
		 
	 }
	 
	 @Test
	 void removeFirstAndLastOccuranceTest() {
		 LinkedList<String> list = new LinkedList<>();
		 assertEquals(false, list.removeFirstOccurrence(null));
		 list.add("A");
		 list.add("B");
		 list.add("A");
		 list.add(null);
		 assertEquals(true, list.removeFirstOccurrence("A"));
		 assertEquals(true, list.removeLastOccurrence("A"));
		 assertEquals(true, list.removeLastOccurrence(null));
		 assertEquals(false, list.removeLastOccurrence(null));
		 assertEquals(false, list.removeLastOccurrence("C"));
		 
	 }
	 @Test
	 void toArrayTest() {
		 LinkedList<String> list = new LinkedList<>();
		 list.add("A");
		 list.add("B");
		 
		 String[] a = new String[1];
		 String[] b = new String[2]; //same size
		 String[] c = new String[3];
		 
		 String[] d = list.toArray(a);
		 String[] e = list.toArray(b);
		 String[] f = list.toArray(c);
		 
		 assertArrayEquals(new String[] {"A", "B"}, d );// smaller size
		 assertArrayEquals(new String[] {"A", "B"}, e ); // larger size array
		 assertArrayEquals(new String[] {"A", "B",null}, f ); //same size
		 
		 
		 
		 
	 }
}
