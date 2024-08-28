// Importing the specific class from the package
import java.util.Date;
// Importing all classes from the package
import java.util.*;

class ImportDemo {
    public static void main(String[] args) {
        // Using fully qualified name to create an instance of the class
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Using the imported class directly
        Date date = new Date();
        System.out.println("Current Date and Time (using specific class import): " + sdf.format(date));

        // Using classes from the java.util package (wildcard import)
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current Date and Time using Calendar (wildcard import): " + sdf.format(calendar.getTime()));
        // Printing Lab information
        System.out.println("\nQuestion No.: 10");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
