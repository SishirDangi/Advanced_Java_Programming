import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class KeyboardToFileExample {
    public static void main(String[] args) {
        String filePath = "output.txt"; // The file to write data to

        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(filePath)) {

            System.out.println("Enter text to write to the file (type 'exit' to finish):");

            // Read lines from the keyboard until "exit" is entered
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")) {
                writer.write(input + System.lineSeparator());
            }

            System.out.println("Data has been written to " + filePath);

            // Printing Lab information
            System.out.println("\nQuestion No.: 14h");
            System.out.println("Name: Sishir Dangi");
            System.out.println("Roll No.: 26740");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
