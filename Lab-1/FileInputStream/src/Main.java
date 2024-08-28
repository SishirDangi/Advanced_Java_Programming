import java.io.FileInputStream;
import java.io.IOException;

class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            // Specify the path to your file
            fis = new FileInputStream("example.txt");

            int content;
            while ((content = fis.read()) != -1) {
                // Print the content as characters
                System.out.print((char) content);
            }
        } catch (IOException e) {
            System.out.println("File not found or unable to read file.");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file.");
            }
        }

        // Printing Lab information
        System.out.println("\nQuestion No.: 14a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
