package hw2;

import java.util.Scanner;

public class WordPalindromeTest {
	
	
	public static boolean checkPalindrome(String[] str)
	{
		int low = 0;
		int high = str.length - 1;
		boolean check = true;
		while(low < high)
		{
			if(str[low].equals(str[high]) == false)
			{
				check = false;
				break;
			}
			low++;
			high--;
		}
		return check;
	}
	
	public static String[] stringMakeover(String str)
	{
		String[] strArray = str.split("\\s+");
		/*for(int i = 0 ; i < strArray.length ; i++)
		{
			System.out.println(strArray[i]);
		}*/
		for(int i = 0 ; i < strArray.length ; i++)
		{
			for(int j = 0 ; j < strArray[i].length() ; j++)
			{
				if(Character.isLetter(strArray[i].charAt(j)) == false && Character.isDigit(strArray[i].charAt(j)) == false)
				{
					strArray[i] = strArray[i].replace(Character.toString(strArray[i].charAt(j)),"");
				}
			}
			strArray[i] = strArray[i].toLowerCase();
		}
		return strArray;
	}

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Welcome to test Word Palindrome Program!!!!");
		
		System.out.println("Type a string to check Word Palindrome : ");
		
		System.out.println("Enter quit to terminate!!");
		
		while(userInput.hasNextLine())
		{
		
			String str = userInput.nextLine();
			
			if(str.equals("quit"))
			{
				System.out.println("Bye!!!!");
				break;
			}
		
			String[] strArray = stringMakeover(str);
		
			boolean check = checkPalindrome(strArray);
		
			if(check == true)
				System.out.println("Palindrome!!!");
			else
				System.out.println("Not a Palindrome!!!");
		}
		userInput.close();

	}

}
