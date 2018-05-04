package hw1;
import java.util.Scanner;
public class ArrayStatistics {

	//private static final double YOU_MUST_COMPLETE_THIS_METHOD = -999.0;
	public static double getMin(double[] numbers)
	{
		double min = Integer.MAX_VALUE;
		for(int i = 0 ; i < numbers.length ; i++)
		{
			min = Math.min(numbers[i], min);
		}
		return min;
	}
	
	public static double getMax(double[] numbers)
	{
		double max = Integer.MIN_VALUE;
		for(int i = 0 ; i < numbers.length ; i++)
		{
			max = Math.max(numbers[i], max);
		}
		return max;
	}
	
	public static double getSum(double[] numbers)
	{
		double sum = 0;
		for(int i = 0 ; i < numbers.length ; i++)
		{
			sum += numbers[i];
		}
		return sum;
	}
  public static void main(String[] args) {

    // Print out welcome message

    System.out.println("\nWelcome to the Array Statistics Program!");

    // Define a scanner for user input

    Scanner userInput = new Scanner(System.in);
    
    // Ask for the number of doubles to input

    System.out.println("\nHow many doubles would you like to input?");
    int n = userInput.nextInt();
    
    double[] numbers = new double[n];

    for(int i = 0; i < n; ++i) {
      System.out.println("Please input a double:");
      numbers[i] = userInput.nextDouble(); 
    }
    
    double sum = getSum(numbers);
    double max = getMax(numbers);
    double min = getMin(numbers);
    
    System.out.println("\nThe average is: " + (sum/n));
    System.out.println("The maximum is: " + max);
    System.out.println("The minimum is: " + min);
    
    userInput.close();

  }
}
