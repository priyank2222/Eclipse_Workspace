package binary_search;

public class BinarySearch {
	
	private int[] arr;
	private int number;
	public BinarySearch(int[] arr,int number)
	{
		this.arr = arr;
		this.number = number;
	}
	
	public int binary_search()
	{
		int len = arr.length;
		int start = 0;
		int end = len - 1;
		int mid = len / 2;
		int x = 1;
		while(arr[mid] != number)
		{
			System.out.println(x);
			if(arr[mid] < number)
			{
				start = mid;
				mid = start + ((end - start) / 2);
			}
			
			else
			{
				end = mid;
				mid = start + ((end-start) / 2);
			}
			x++;
		}
		return arr[mid];
	}

}
