package A03;

import java.util.Comparator;

public class Term implements Comparable<Term> {

	/////////////////////////////////////////////////////////////
	// fields
	private String query;
	private Double weight;

	/////////////////////////////////////////////////////////////
	// public methods

	// Initialize a term with the given query string and weight.
	public Term(String query, double weight) {
		if (query == null)
			throw new NullPointerException();
		if (weight < 0)
			throw new IllegalArgumentException();

		this.query = query;
		this.weight = weight;

	}

	// Compare the terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder() {
		return new ByReverseWeightOrder();
	}

	// Compare the terms in lexicographic order but using only the first r
	// characters of each query.
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0)
			throw new IllegalArgumentException();
		return new ByPrefixOrder(r);
	}

	// Compare the terms in lexicographic order by query.
	public int compareTo(Term that) {
		return this.query.compareTo(that.query);
	}

	// Return a string representation of the term in the following format:
	// the weight, followed by a tab, followed by the query.
	public String toString() {
		return (weight + "\t" + query);
	}

	/////////////////////////////////////////////////////////////
	// private methods

	/////////////////////////////////////////////////////////////
	// private classes

	private static class ByReverseWeightOrder implements Comparator<Term> {

		@Override
		public int compare(Term a, Term b) {

			return b.weight.compareTo(a.weight);
			// double cmp = b.weight - a.weight;
			// if (cmp < 0)
			// return -1;
			// else if (cmp > 0)
			// return 1;
			// else
			// return 0;
			// return (int)(b.weight - a.weight); This wouldn't work since
			// differences > 0 and < 1 would get truncated to 0
		}

	}

	private static class ByPrefixOrder implements Comparator<Term> {

		// field
		int r;

		public ByPrefixOrder(int r) {
			this.r = r;
		}

		@Override
		public int compare(Term a, Term b) {
			String s1 = a.query.substring(0, r);
			String s2 = b.query.substring(0, r);
			return s1.compareTo(s2);
		}

	}

	/////////////////////////////////////////////////////////////
	// main method for testing

	public static void main(String[] args) {
		double a = 1;
		double b = .999999999999;
		double c = a - b;
		System.out.println(c + " -> " + (int) c);

	}

}