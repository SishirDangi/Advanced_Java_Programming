// Final class - cannot be inherited
final class FinalClass {
    // Final variable - its value cannot be changed once assigned
    final int finalVar = 100;

    // Final method - cannot be overridden
    public final void displayFinal() {
        System.out.println("This is a final method in a final class.");
        System.out.println("Final variable value: " + finalVar);
    }
}

class FinalKeywordDemo {
    // Final variable in this class
    final int finalValue;

    // Constructor to initialize the final variable
    public FinalKeywordDemo(int value) {
        this.finalValue = value;
    }

    // Method to display the final variable
    public void display() {
        System.out.println("Final variable in this class: " + finalValue);
    }

    public static void main(String[] args) {
        // Creating an object of FinalKeywordDemo
        FinalKeywordDemo demo = new FinalKeywordDemo(50);
        demo.display();

        // Creating an object of FinalClass to demonstrate final method and variable
        FinalClass finalObj = new FinalClass();
        finalObj.displayFinal();

        // Printing Lab information
        System.out.println("\nQuestion No.: 5d");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
