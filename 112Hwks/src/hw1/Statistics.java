package hw1;

import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {

        // Define a scanner for user input 
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("\nType in the first number and then hit return:"); 
        int numOne = userInput.nextInt(); 
        
        System.out.println("\nType in the second number and then hit return:");
        int numTwo = userInput.nextInt();
        
        System.out.println("\nType in the third number and then hit return:");
        int numThree = userInput.nextInt();
        
        int sum = numOne + numTwo + numThree;
        System.out.println("Sum of three numbers : " + sum);
        
        int max = Math.max(numOne , Math.max(numTwo, numThree));
        System.out.println("Max of three numbers : " + max);
        
        int min = Math.min(numOne , Math.min(numTwo, numThree));
        
        int range = max - min;
        System.out.println("Range of three numbers : " + range);
        
        double mean = sum / 3;
        System.out.printf("Mean of three numbers : %.4f\n" , mean);
        
        int median = Math.max(numOne, Math.min(numTwo, numThree));
        
        double sd = Math.sqrt((numOne - median)*(numOne - median) + (numTwo - median)*(numTwo - median) + (numThree - median)*(numThree - median) / 2);
        System.out.printf("Standard Deviation of three numbers : %.4f\n" , sd);
        
        System.out.println("Ascending Order : " + min + " " + median + " " + max);
        
        userInput.close();
        
    }
}
