package edu.smith.cs.csc212.sorts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SlowSortsTest {

	@Test
	public void testInsertSortedEmpty() {
		ListADT<Integer> empty = new JavaList<>();

		ListADT<Integer> expected = new JavaList<>();
		expected.addBack(7);

		SlowSorts.insertSorted(7, empty);
		assertEquals(expected, empty);
	}
	
        @Test
        public void testInsertSortedFront() {
            ListADT<Integer> actual = new JavaList<>();
            actual.addBack(2);
            actual.addBack(3);

            ListADT<Integer> expected = new JavaList<>();
            expected.addBack(1);
            expected.addBack(2);
            expected.addBack(3);

            SlowSorts.insertSorted(1, actual);
            assertEquals(expected, actual);
        }
	
	@Test
	public void testInsertSortedMiddle() {
		ListADT<Integer> actual = new JavaList<>();
		actual.addBack(1);
		actual.addBack(3);

		ListADT<Integer> expected = new JavaList<>();
		expected.addBack(1);
		expected.addBack(2);
		expected.addBack(3);

		SlowSorts.insertSorted(2, actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testInsertSortedBack() {
		ListADT<Integer> actual = new JavaList<>();
		actual.addBack(1);
		actual.addBack(2);

		ListADT<Integer> expected = new JavaList<>();
		expected.addBack(1);
		expected.addBack(2);
		expected.addBack(3);

		SlowSorts.insertSorted(3, actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindMin() {
		ListADT<Integer> example = new JavaList<>();
		for (int x : new int[] { 8, 6, 7, 0, 3, 5, 9 }) {
			example.addBack(x);
		}
		assertEquals(7, example.size());

		// The minimum in the list is 0, which is at position 3.
		// Any "start" value less than 3 will identify it.
		assertEquals(3, SlowSorts.findMinPosition(example, 0));
		assertEquals(3, SlowSorts.findMinPosition(example, 1));
		assertEquals(3, SlowSorts.findMinPosition(example, 2));
		assertEquals(3, SlowSorts.findMinPosition(example, 3));
		// the sequence 3,5,9 are in positions 4,5,6.
		assertEquals(4, SlowSorts.findMinPosition(example, 4));
		assertEquals(5, SlowSorts.findMinPosition(example, 5));
		assertEquals(6, SlowSorts.findMinPosition(example, 6));
	}

	@Test
	public void testInsertionSort() {
		ListADT<Integer> start = new JavaList<>();
		for (int x : new int[] { 8, 6, 7, 5, 7, 3, 0, 9 }) {
			start.addBack(x);
		}
		ListADT<Integer> expected = new JavaList<>();
		for (int x : new int[] { 0, 3, 5, 6, 7, 7, 8, 9 }) {
			expected.addBack(x);
		}
		ListADT<Integer> actual = SlowSorts.insertionSort(start);
		assertEquals(expected, actual);
	}

	@Test
	public void testSelectionSort() {
		ListADT<Integer> actual = new JavaList<>();
		for (int x : new int[] { 8, 6, 7, 5, 7, 3, 0, 9 }) {
			actual.addBack(x);
		}
		ListADT<Integer> expected = new JavaList<>();
		for (int x : new int[] { 0, 3, 5, 6, 7, 7, 8, 9 }) {
			expected.addBack(x);
		}
		SlowSorts.selectionSort(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testIsSorted() {
		ListADT<Integer> actual = new JavaList<>();
		assertTrue("Empty lists are sorted.", SlowSorts.isSorted(actual));

		actual.addBack(3);
		assertTrue("Size-1 lists are sorted.", SlowSorts.isSorted(actual));

		actual.addBack(4);
		assertTrue("[3,4] is sorted.", SlowSorts.isSorted(actual));

		actual.addBack(1);
		assertFalse("[3,4,1] is NOT sorted.", SlowSorts.isSorted(actual));
	}
}
