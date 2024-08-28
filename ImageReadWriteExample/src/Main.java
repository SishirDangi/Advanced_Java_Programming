import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ImageCopyDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Specify the source image file
            fis = new FileInputStream("source_image.jpg");

            // Specify the destination image file
            fos = new FileOutputStream("copied_image.jpg");

            int byteData;
            while ((byteData = fis.read()) != -1) {
                // Write the byte data to the destination file
                fos.write(byteData);
            }

            System.out.println("Image has been copied successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred during file operation.");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file.");
            }
        }

        // Printing Lab information
        System.out.println("\nQuestion No.: 13c");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
