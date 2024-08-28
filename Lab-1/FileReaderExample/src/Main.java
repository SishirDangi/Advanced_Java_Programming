import java.io.FileReader;
import java.io.IOException;

class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Make sure this file exists in your working directory

        try (FileReader reader = new FileReader(filePath)) {
            int character;
            System.out.println("Contents of the file:");

            // Read the file character by character
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

            // Printing Lab information
            System.out.println("\nQuestion No.: 14f");
            System.out.println("Name: Sishir Dangi");
            System.out.println("Roll No.: 26740");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
