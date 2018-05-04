package hw1;

public class SquareRoot {

	//private static final int YOU_MUST_COMPLETE_THIS_METHOD = -1;

	// squareRoot returns the floor of the square root of n (i.e., rounded down to nearest integer).

	  public static int squareRoot(int n) {
		  
		  int low = 0;
		  int high = n;
		  int mid = 0;
		  
		  for(int i = 0 ; i < n + 1 ; i++)
		  {
			  mid = (high + low) / 2;
			  if((n / mid) == mid)
				  return mid;
			  else if((n / mid) < mid)
				  high = mid;
			  else  low = mid;
		  }
		  
		return mid;
		    }

	  public static void main(String[] args) {
	    System.out.println(squareRoot(25)); //must print 5
	    System.out.println(squareRoot(256)); //must print 16
	    System.out.println(squareRoot(10));  //must print 3                                  

	  }
}
