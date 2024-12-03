import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to the server!");

            // Input and output streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // Auto-flush enabled

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage, serverMessage;

            while (true) {
                System.out.print("Client: ");
                clientMessage = consoleInput.readLine();
                output.println(clientMessage); // Send client message to server

                if ("exit".equalsIgnoreCase(clientMessage)) {
                    System.out.println("Client exiting...");
                    break;
                }

                serverMessage = input.readLine(); // Receive server response
                if (serverMessage == null) {
                    System.out.println("Server disconnected!");
                    break;
                }
                System.out.println("Server: " + serverMessage);
            }

            socket.close();
        } catch (IOException e) {
            System.err.println("Client Error: " + e.getMessage());
        }
    }
}
