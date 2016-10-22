package A03;

import java.util.Comparator;

public class BinarySearchDeluxe {

	/*
	 * I looked through Adam Gradner's code as a guideline before implementing my own
	 * version
	 */

	// Return the index of the first key in a[] that equals the search key, or
	// -1 if no such key.
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		// check for nulls
		if (a == null || key == null || comparator == null) {
			throw new NullPointerException();
		}
		// make sure array is not empty
		if (a.length == 0)
			return -1;

		// vars
		int lo = 0;
		int hi = a.length - 1;
		int mid;

		// keep splitting until hi and lo are close together
		while (hi - lo > 1) {
			mid = (lo + hi) / 2;
			if (comparator.compare(a[mid], key) < 0)
				lo = mid;
			else
				hi = mid;
		}
		// check hi and lo for the key
		if (comparator.compare(key, a[lo]) == 0)
			return lo;
		if (comparator.compare(key, a[hi]) == 0)
			return hi;
		// if key is not in array
		return -1;
	}

	// Return the index of the last key in a[] that equals the search key, or -1
	// if no such key.
	// NOTE: Copied and pasted from previous method, with some minor tweaks
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		// check for nulls
		if (a == null || key == null || comparator == null) {
			throw new NullPointerException();
		}
		// make sure array is not empty
		if (a.length == 0)
			return -1;

		// vars
		int lo = 0;
		int hi = a.length - 1;
		int mid;

		// keep splitting until hi and lo are close together
		while (hi - lo > 1) {
			mid = (lo + hi) / 2;
			if (comparator.compare(a[mid], key) > 0)
				hi = mid;
			else
				lo = mid;
		}
		// check hi and lo for the key
		if (comparator.compare(key, a[hi]) == 0)
			return hi;
		if (comparator.compare(key, a[lo]) == 0)
			return lo;
		// if key is not in array
		return -1;
	}
}