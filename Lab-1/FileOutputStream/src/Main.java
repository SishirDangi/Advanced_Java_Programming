import java.io.FileOutputStream;
import java.io.IOException;

class FileOutputStreamDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            // Specify the path to your file
            fos = new FileOutputStream("output.txt");

            // Data to be written to the file
            String data = "Hello, World! This is a test. My name is Sishir Dangi.";

            // Convert the string data to bytes
            byte[] byteData = data.getBytes();

            // Write the byte data to the file
            fos.write(byteData);

            System.out.println("Data has been written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the file.");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file.");
            }
        }

        // Printing Lab information
        System.out.println("\nQuestion No.: 14b");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
