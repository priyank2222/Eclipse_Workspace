/*
 * Student First Name:
 * Student Last Name:
 * Student BU Number:
 * Purpose: 
 */
package hw3;

public class BigMerge {
	
	/*
	 * Returns j such that a[j][index[j]] is the minimum
	 * of the set S={a[i][index[i]] for every i such that index[i]<a[i].length}
	 * If the set S is empty, returns -1
	 * Runs in time a.length.
	 * 
	 * NOTE: normally this would be private, but leave it
	 * public so we can test it separately from your merge.
	 */
	public static int argMin(int[][] a, int[] index) {
		// TODO: Implement this using a similar method to
		// how we find the minimum in, for example, selection sort.
		// Watch out for the case when index[i]==a[i].length
		// Implement this before you try to implement merge
        // FYI: in our version, this takes up 13 lines of code

		return -1; // just a place holder for now, so compiler doesn't complain
	}
	
	/*
	 * Assumes a[0]...a[length-1] each is sorted in increasing order
	 * Returns a single sorted array containing all the elements in a
	 * Does not modify a. 
	 * Runs in time k^2 * n, where k is a.length and n is the
	 * total number of integers in a.
	 */
	public static int[] merge (int[][] a) {
		// TODO: implement.
		// Suggestions: calculate the length of returned array ret
		// and create ret.
	  int total_elements = 0;
	  for(int i = 0 ; i < a.length ; i++)
	  {
	    for(int j = 0 ; j < a[i].length ; j++)
	    {
	      total_elements++;
	    }
	  }
	  
	  
	  for(int i = 0 ; i < a.length ; i++)
	  {
	    int[] index = {};
	    for(int j = 0 ; j < a[i].length ; j++)
	    {
	      
	    }
	  }
	  //System.out.println(total_elements);
		// Maintain an array called index of length a.length
		// that has your current index into each of the arrays of a
		// (that is, you have a.length indices instead of just
		// the two indices maintained merge in mergeSort)
		// At each iteration, use the argMin method implemented above
		// to decide which element gets to move into ret.
        // FYI: in our version, this takes up 12 lines of code

		int[] ret = new int[total_elements]; // just a placeholder -- change as needed
		return ret; // just a placeholder -- change as needed
	}
}
