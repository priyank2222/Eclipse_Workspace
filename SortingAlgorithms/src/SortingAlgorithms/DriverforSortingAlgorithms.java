package SortingAlgorithms;

public class DriverforSortingAlgorithms {

  public static void main(String[] args) {
    
    int[] sort = {4,3,7,6,5};
    System.out.println("Array Without Sorting");
    printArray(sort);
   // SortingAlgorithms.bubbleSort(sort);
    SortingAlgorithms.selectionSort(sort);
    System.out.println("Array After Sorting");
    printArray(sort);

  }
  
  public static void printArray(int[] array)
  {
    int counter = 0;
    while(counter < array.length)
    {
      System.out.print(array[counter] + " ");
      counter++;
    }
    System.out.println();
  }

}