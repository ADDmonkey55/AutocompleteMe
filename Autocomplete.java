package A03;

import java.util.Arrays;

public class Autocomplete {

	Term[] terms;
	
    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
    	Arrays.sort(terms);
    	this.terms = terms;
    	for (Term t : terms)
    		System.out.println(t);
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
    	Term p = new Term(prefix, 0);
    	int first = BinarySearchDeluxe.firstIndexOf(terms, p, Term.byPrefixOrder(prefix.length()));
    	int last = BinarySearchDeluxe.lastIndexOf(terms, p, Term.byPrefixOrder(prefix.length()));
    	Term[] range = Arrays.copyOfRange(terms, first, last);
    	System.out.println("range found");
    	System.out.println(range.length);
    	for (Term t : range)
    		System.out.println(t);
    	
    	
    	return range;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
    	return 0;
    }
    
    
    public static void main(String[] args) {
    	Term t1 = new Term("test",0);
    	Term t2 = new Term("teleport",0);
    	Term t3 = new Term("table",0);
    	Term t4 = new Term("word",0);
    	Term t5 = new Term("te",0);
    	Term[] t = new Term[] {t1,t2,t3,t4,t5};
    	
    	Autocomplete a = new Autocomplete(t);
    	a.allMatches("te");
    	
    	;
    	
    }
    
}