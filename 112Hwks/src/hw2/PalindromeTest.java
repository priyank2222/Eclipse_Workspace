package hw2;

import java.util.Scanner;

public class PalindromeTest {

	
	public static boolean palindromeCheck(String str)
	{
		int low = 0;
		int high = str.length() - 1;
		boolean check = true;
		while(low < high)
		{
			if(str.charAt(low) != str.charAt(high))
			{
				check = false;
				break;
			}
			low++;
			high--;
		}
		return check;
	}
	
	public static String stringMakeover(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(Character.isLetter(str.charAt(i)) == false && Character.isDigit(str.charAt(i)) == false)
			{
				str = str.replace(Character.toString(str.charAt(i)),"");
			}
		}
		str = str.toLowerCase();
		return str;
	}
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Welcome to test Palindrome Program!!!!");
		
		System.out.println("Enter any String to check whether it is Palindrome or not : ");
		
		System.out.println("Enter quit to terminate!!");
		
		while(userInput.hasNextLine())
		{
		
			String str = userInput.nextLine();
		
			str = stringMakeover(str);
			if(str.equals("quit"))
			{
				System.out.println("Bye!!!!");
				break;
			}
			boolean check = palindromeCheck(str);
			if(check == true)
				System.out.println("Palindrome!!!");
			else
				System.out.println("Not a Palindrome!!!");
		}

		userInput.close();
	}

}
