package hw2;

import java.util.Scanner;

public class Histogram {
  public static final int MAX_NUMBERS = 20;
  public static final int NUM_BINS = 10;

  public static void printHeading() {
    System.out.println("Welcome to the Histogram Program!!");
    System.out.println("Enter upto 20 numbers in the range from [0,100] : ");
  }

  public static boolean validInput(double temp) {
    boolean check = true;
    if (temp < -1 || temp > 100)
      check = false;
    return check;
  }

  public static void printHistogram(double[] numbers) {
    int count1 = 0;
    System.out.print("[" + 0 + "-" + 10 + "] : \t");
    for (int loop10 = 0; loop10 < numbers.length; loop10++) {
      if (numbers[loop10] >= 0 && numbers[loop10] <= 10)
        count1++;
    }
    for (int i = 0; i < count1; i++) {
      System.out.print("*");
    }
    System.out.println();
    for (int start = 10; start < 100; start += 10) {
      int min = start;
      int max = start + 10;
      int count = 0;
      System.out.print("(" + min + "-" + max + "] : \t");
      for (int arrloop = 0; arrloop < numbers.length; arrloop++) {
        if (numbers[arrloop] > min && numbers[arrloop] <= max)
          count++;
      }
      for (int i = 0; i < count; i++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    printHeading();

    Scanner userInput = new Scanner(System.in);
    int arrlength = 0;
    double[] numbers = new double[MAX_NUMBERS];
    // Initializing the array values to -2 as array will be taking all the non-used array values as
    // 0
    // And initialized 0 values were giving trouble to the output
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = -2;
    }

    for (int i = 0; userInput.hasNextDouble(); i++) {
      double temp = userInput.nextDouble();

      if (validInput(temp) == true) {
        if (temp == -1)
          break;
        numbers[i] = temp;
        arrlength = i + 1;
      }

      else {
        System.out.println("Please Enter Numbers between 0 and 100!!!");
        i--;
      }
    }

    System.out.print("Your " + arrlength + " inputs : ");

    for (int i = 0; i < arrlength; i++) {
      System.out.print(" " + numbers[i]);
    }
    System.out.println();

    printHistogram(numbers);

    userInput.close();
  }

}
