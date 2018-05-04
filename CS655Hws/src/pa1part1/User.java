package pa1part1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class User {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		Socket userSocket = new Socket("localhost",1342);
		
		Scanner input_stream = new Scanner(userSocket.getInputStream());
		
		System.out.println("Enter the message : ");
		String str = sc.nextLine();
		String authority = "#status";
		PrintStream output_stream = new PrintStream(userSocket.getOutputStream());
		str = authority.concat(str);
		output_stream.println(str);
		
		String input = input_stream.nextLine();
		if(input.startsWith("#statusPosted"))
		{
			System.out.println(input.substring(13));
			userSocket.close();
			sc.close();
			input_stream.close();
		}
		else
			System.out.println(input);
		
	}

}
