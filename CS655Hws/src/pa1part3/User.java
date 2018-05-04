package pa1part3;

import java.io.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class User implements Runnable {

    private static Socket userSocket = null;
    private static PrintStream output_stream = null;
    private static BufferedReader input_stream = null;
    private static String inputLine;
    private static Thread listeningThread = null;
    private static boolean exit = false;

    public static void main(String[] args) {
        int portNumber = 8000;
        String host = "localhost";
        String sentence;
        String responseLine;
        if (args.length < 2) {
            System.out.println("Usage: java User <host> <portNumber>\n"
                    + "Now using host=" + host + ", portNumber=" + portNumber);
        } else {
            host = args[0];
            portNumber = Integer.valueOf(args[1]).intValue();
        }
        /*
         * Open a socket on a given host and port. Open input and output streams.
         */
        try {
            userSocket = new Socket(host, portNumber);
            output_stream = new PrintStream(userSocket.getOutputStream());
            input_stream = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input_stream));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to the host "
                    + host);
        }

        System.out.println("Connecting to the Server!!!!");
        listeningThread = new Thread();
        try {
            new Thread(new User()).start();
            while (!exit) {                      //keep writing message to server till logout
                inputLine = new BufferedReader(new InputStreamReader(System.in)).readLine();
                output_stream.write((inputLine + "\n").getBytes());
            }

        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }

    public void run() {
        try {
            String sentence;
            input_stream = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));

            while (!exit) {                                           //keep reading message from others till logout
                sentence = input_stream.readLine();
                System.out.println(sentence);
                if (sentence.equals("exit") == true) {
                    break;
                }
            }
            System.out.println("Exit");
            exit = true;
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }
}
