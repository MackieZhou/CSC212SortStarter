package edu.smith.cs.csc212.sorts;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.errors.TODOErr;
import me.jjfoley.adt.impl.JavaList;

public class MergeSort {

	/**
	 * This method walks through two sorted input lists and creates an output list
	 * that contains all elements from the two inputs.
	 * 
	 * @param lhs - a sorted list.
	 * @param rhs - a sorted list.
	 * @return a sorted list containing all of the items from lhs and rhs.
	 */
	public static ListADT<Integer> combineTwoSortedLists(ListADT<Integer> lhs, ListADT<Integer> rhs) {
		ListADT<Integer> output = new JavaList<>();
		int lSize = lhs.size();
		int rSize = rhs.size();

		while (output.size() < lSize + rSize) {
			if (lhs.isEmpty()) {
				output.addBack(rhs.removeFront());
			} else if (rhs.isEmpty()) {
				output.addBack(lhs.removeFront());
			} else if (lhs.getFront() <= rhs.getFront()) {
				output.addBack(lhs.removeFront());
			} else {
				output.addBack(rhs.removeFront());
			}
		}

		return output;
	}

	/**
	 * Recursively sort this list by breaking it in half and piecing it back
	 * together. You will need to call
	 * {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
	 *
	 * @param input - the input list.
	 * @return a new list containing the sorted output.
	 */
	public static ListADT<Integer> doMergeSortRecursively(ListADT<Integer> input) {
		if (input.size() > 1) {
			int size = input.size();
			int mid = size / 2;
			ListADT<Integer> left = input.slice(0, mid);
			ListADT<Integer> right = input.slice(mid, size);
			return combineTwoSortedLists(doMergeSortRecursively(left), doMergeSortRecursively(right));
		} else {
			return input;
		}
	}

	/**
	 * Iteratively sort this list by breaking it in half and piecing it back
	 * together. You will need to call
	 * {@linkplain #combineTwoSortedLists(ListADT, ListADT)}.
	 * 
	 * @param input - the input list.
	 * @return a new list containing the sorted output.
	 */
	public static ListADT<Integer> doMergeSortIteratively(ListADT<Integer> input) {
		ListADT<ListADT<Integer>> work = new JavaList<>();
		for (int i : input) {
			ListADT<Integer> smallList = new JavaList<>();
			smallList.addBack(i);
			work.addBack(smallList);
		}

		while (work.size() > 1) {
			ListADT<Integer> biggerList = combineTwoSortedLists(work.removeFront(), work.removeFront());
			work.addBack(biggerList);
		}

		return work.getFront();
	}
}
