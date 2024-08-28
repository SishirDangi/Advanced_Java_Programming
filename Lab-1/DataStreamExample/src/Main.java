import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class DataStreamExample {
    public static void main(String[] args) {
        // File paths for writing and reading
        String filePath = "datafile.dat";

        // Writing data to a file
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            // Write various data types
            dataOutputStream.writeInt(123);
            dataOutputStream.writeDouble(45.67);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeUTF("Hello, World!");

            System.out.println("Data has been written to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Reading data from the file
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
            // Read the data in the same order it was written
            int intValue = dataInputStream.readInt();
            double doubleValue = dataInputStream.readDouble();
            boolean booleanValue = dataInputStream.readBoolean();
            String stringValue = dataInputStream.readUTF();

            System.out.println("Data read from the file:");
            System.out.println("Integer: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("Boolean: " + booleanValue);
            System.out.println("String: " + stringValue);
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
        // Printing Lab information
        System.out.println("\nQuestion No.: 14d");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
