import java.io.FileWriter;
import java.io.IOException;

class FileWriterExample {
    public static void main(String[] args) {
        String filePath = "output.txt"; // The file to write data to

        try (FileWriter writer = new FileWriter(filePath)) {
            // Writing data to the file
            writer.write("Hello, this is a test file.\n");
            writer.write("It contains multiple lines of text.\n");
            writer.write("This is written using FileWriter in Java.\n");

            System.out.println("Data has been written to " + filePath);

            // Printing Lab information
            System.out.println("\nQuestion No.: 14g");
            System.out.println("Name: Sishir Dangi");
            System.out.println("Roll No.: 26740");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
