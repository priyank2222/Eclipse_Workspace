package pa1part2;

//package broadcast;

import java.io.PrintStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.*;



/*
* A server that delivers status messages to other users.
*/
public class Server {

	// Create a socket for the server 
	private static ServerSocket serverSocket = null;
	// Create a socket for the server 
	private static Socket userSocket = null;
	// Maximum number of users 
	private static int maxUsersCount = 5;
	// An array of threads for users
	private static userThread[] users = null;


	public static void main(String args[]) {

		// The default port number.
		int portNumber = 8000;
		if (args.length < 2) {
			System.out.println("Usage: java Server <portNumber>\n"
					+ "Now using port number=" + portNumber + "\n" +
					"Maximum user count=" + maxUsersCount);
		} else {
			portNumber = Integer.valueOf(args[0]).intValue();
			maxUsersCount = Integer.valueOf(args[1]).intValue();
		}

		System.out.println("Server now using port number=" + portNumber + "\n" + "Maximum user count=" + maxUsersCount);
		
		// Array of userThread objects(Maximum = 5 in our case)
		
		users = new userThread[maxUsersCount];


		/*
		 * Open a server socket on the portNumber (default 8000). 
		 */
		try {
			serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			System.out.println(e);
		}

		/*
		 * Create a user socket for each connection and pass it to a new user
		 * thread.
		 */
		while (true) {
			try {
				userSocket = serverSocket.accept();
				int i = 0;
				for (i = 0; i < maxUsersCount; i++) {
					if (users[i] == null) {
						// Calling the userThread Constructor
						users[i] = new userThread(userSocket, users);
						// STrating the thread
						users[i].start();
						break;
					}
				}
	// After filling the maximum spaces for clients, Server will Print Busy Message.
				if(i == maxUsersCount){               
                    System.out.println("#busy");
                    userSocket.close();
                }
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}

/*
* Threads
*/
class userThread extends Thread {
	
	private String userName = null;
	private BufferedReader input_stream = null;
	private PrintStream output_stream = null;
	private Socket userSocket = null;
	private final userThread[] users;
	private int maxUsersCount;

	public userThread(Socket userSocket, userThread[] threads) {
		this.userSocket = userSocket;
		this.users = threads;
		maxUsersCount = threads.length;
	}

	public void run() {
		int maxUsersCount = this.maxUsersCount;
		userThread[] users = this.users;

		try {
			/*
			 * Create input and output streams for this client.
			 * Read user name.
			 */
			input_stream = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));
			output_stream = new PrintStream(userSocket.getOutputStream());
			
			// Asks the user about his/her UserName
			
			output_stream.println("Enter Your Username and Start with '#join ' : ");
			
			String message = input_stream.readLine().trim();
			
			if(message.startsWith("#join"))
			{
				this.userName = message.substring(6);
				// Print Welcome Message
				output_stream.println("#welcome "+this.userName);
			}
			
			// Broadcast the "#newUser Message"
			for(int i = 0 ; i < maxUsersCount ; i++) {
                if(users[i] != null && users[i] != this){  // Broadcasting
                    users[i].output_stream.println("#newuser "+userName);
                    System.out.println(userName+" Entered!!!");
                }
            }


			/* Start the conversation. */
			while (true) {
				// Read the message from user
				String messageLine = input_stream.readLine();
				// Print the message with UserName 
				System.out.println(this.userName +" : " +messageLine);
				// Break the loop if user types "exit"
				if(messageLine.equals("Exit"))
					break;
				// Otherwise broadcast the message to all the other user
				else if(messageLine.startsWith("#status"))
				{
					output_stream.println("#statusPosted");
					for (int i = 0 ; i < maxUsersCount ; i++) { //broadcasting
                        if (users[i] != null && users[i] != this) {
                            users[i].output_stream.println("#newStatus"+ " " +userName + " "+messageLine.substring(7));
                        }
                    }
				}

			}
			// When user types "exit" loop breaks and server informs other user that particular user left
			for(int i = 0 ; i < maxUsersCount ; i++) {               //Broadcasting
                if(users[i] != null && users[i] != this){
                    users[i].output_stream.println("#Leave " +userName);
                }
            }
			
			output_stream.println("#Bye");
			
			//close the thread
			
			for(int i=0;i<maxUsersCount;i++){                 
                if(users[i] == this){
                    users[i] = null;
                }
            }

			// conversation ended.

			/*
			 * Clean up. Set the current thread variable to null so that a new user
			 * could be accepted by the server.
			 */
			/*synchronized (userThread.class) {
				for (int i = 0; i < maxUsersCount; i++) {
					if (threads[i] == this) {
						threads[i] = null;
					}
				}
			}*/
			/*
			 * Close the output stream, close the input stream, close the socket.
			 */
			input_stream.close();
			output_stream.close();
			userSocket.close();
		} catch (IOException e) {
			System.out.println("Thread Interrupted");
		}
		System.out.println("Thread Exiting");
	}
}




