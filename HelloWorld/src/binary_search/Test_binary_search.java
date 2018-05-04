package binary_search;

public class Test_binary_search {

	public static void main(String[] args) {
		int[] arr = {2,7,12,15,19,25,26,38,45,78};
		int number = 12;
		BinarySearch bn = new BinarySearch(arr,number);
		int find = bn.binary_search();
		System.out.println(find);
	}

}
