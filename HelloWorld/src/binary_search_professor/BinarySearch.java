 package binary_search_professor;

public class BinarySearch {

	public static void main(String[] args)
	{
		int[] a={2,7,12,15,19,25,26,38,45,78};
		System.out.println(BinarySearch.binarySearch(a,78));
	}
	
	    public static boolean binarySearch(int[] array,int searchItem) 
	    {
	    	 int size=array.length;
	         int low = 0;
	         int high = size - 1;
	         //int x = 1; 
	         while(high >= low) {
	        	 	 //System.out.println(x);
	             int middle = (low + high) / 2;
	             if(array[middle] == searchItem) {
	                 return true;
	             }
	             if(array[middle] < searchItem) {
	                 low = middle + 1;
	             }
	             if(array[middle] > searchItem) {
	                 high = middle - 1;
	             }
	             //x++;
	         }
	         return false;
	   }
}

