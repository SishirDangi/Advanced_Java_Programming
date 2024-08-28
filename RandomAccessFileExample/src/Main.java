import java.io.IOException;
import java.io.RandomAccessFile;

class RandomAccessFileExample {
    public static void main(String[] args) {
        String filePath = "randomaccessfile.txt";

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // Writing data to the file
            raf.writeUTF("Hello, World!");
            raf.writeInt(123);
            raf.writeDouble(45.67);
            raf.writeBoolean(true);

            // Move the file pointer to the beginning
            raf.seek(0);

            // Read the string from the beginning
            String str = raf.readUTF();
            System.out.println("String read from file: " + str);

            // Skip the integer and double values, and read the boolean
            raf.seek(raf.getFilePointer() + 4 + 8);
            boolean boolValue = raf.readBoolean();
            System.out.println("Boolean read from file: " + boolValue);

            // Modify the integer value at position 14
            raf.seek(raf.getFilePointer() - 13); // Move to the integer location
            raf.writeInt(456);
            System.out.println("Integer value at position 14 updated to 456");

            // Move the file pointer to the beginning and read all data
            raf.seek(0);
            System.out.println("Reading updated content from file:");
            System.out.println("String: " + raf.readUTF());
            System.out.println("Integer: " + raf.readInt());
            System.out.println("Double: " + raf.readDouble());
            System.out.println("Boolean: " + raf.readBoolean());

        } catch (IOException e) {
            System.out.println("An error occurred while accessing the file.");
            e.printStackTrace();
        }
        // Printing Lab information
        System.out.println("\nQuestion No.: 14e");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
