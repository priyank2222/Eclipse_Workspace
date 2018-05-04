package pa1part1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		
		while(true)
		{
			ServerSocket ss = new ServerSocket(1342);
			Socket userSocket = ss.accept();
		
			Scanner sc = new Scanner(userSocket.getInputStream());
		
			PrintStream output_stream = new PrintStream(userSocket.getOutputStream());
		
			String str = sc.nextLine();
			
			String authorize = "#statusPosted";
			
			if(str.startsWith("#status") == true)
			{
				String reply = authorize.concat("Message Successfully Received!!!");
				output_stream.println(reply);
				System.out.println("Client : "+str.substring(7));
			}
			else
			{
				System.out.println("Message Not Authorized");
				output_stream.println("Not Authorized");
			}
			ss.close();
			sc.close();
		}
	}

}
