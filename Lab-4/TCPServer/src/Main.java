import java.io.*;
import java.net.*;

 class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Input and output streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // Auto-flush enabled

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage, serverMessage;

            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Client: " + clientMessage);
                if ("exit".equalsIgnoreCase(clientMessage)) {
                    System.out.println("Client disconnected!");
                    break;
                }

                System.out.print("Server: ");
                serverMessage = consoleInput.readLine();
                output.println(serverMessage); // Send server response
                if ("exit".equalsIgnoreCase(serverMessage)) {
                    System.out.println("Server shutting down...");
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}
