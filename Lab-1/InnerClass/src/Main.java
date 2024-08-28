// Outer class
class OuterClass {
    private String outerInstanceField = "Outer Instance Field";

    // Non-static nested class (inner class)
    class InnerClass {
        void display() {
            // Accessing the instance field of the outer class
            System.out.println("Accessing from Inner Class:");
            System.out.println("Outer Instance Field: " + outerInstanceField);
        }
    }

    // Method to demonstrate instance access
    void instanceMethod() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the outer class
        OuterClass outerObject = new OuterClass();

        // Create an instance of the inner class
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.display();

        // Also, demonstrating instance method
        outerObject.instanceMethod();

        // Printing Lab information
        System.out.println("\nQuestion No.: 9b");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
