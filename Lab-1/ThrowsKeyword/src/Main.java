import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ThrowsKeyword {

    // Method that declares it might throw an IOException
    public static void readFile(String filePath) throws IOException {
        // Create a BufferedReader to read the file
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Read the first line of the file
        String line = reader.readLine();
        System.out.println("First line of the file: " + line);

        // Close the reader
        reader.close();
    }

    public static void main(String[] args) {
        try {
            // Call the method that throws an IOException
            readFile("example.txt");
        } catch (IOException e) {
            // Handle the IOException
            System.out.println("IOException caught: " + e.getMessage());
        } finally {
            // Finally block to execute code regardless of exception
            System.out.println("Finally block executed.");
        }

        // Additional code after exception handling
        System.out.println("Program continues after try-catch-finally blocks.");

        // Printing Lab information
        System.out.println("\nQuestion No.: 12e");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
