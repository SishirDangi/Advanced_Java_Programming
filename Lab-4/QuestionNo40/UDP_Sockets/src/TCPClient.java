import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to the server.");

            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            String clientMessage = "Hello from client!";
            out.println(clientMessage);
            System.out.println("Client: " + clientMessage);

            // Read the server's response
            String serverResponse = in.readLine();
            System.out.println("Server: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
