// Outer class
class OuterClass {
    private static String outerStaticField = "Outer Static Field";
    private String outerInstanceField = "Outer Instance Field";

    // Static nested class
    static class StaticNestedClass {
        void display() {
            // Accessing the static field of the outer class
            System.out.println("Accessing from Static Nested Class:");
            System.out.println("Outer Static Field: " + outerStaticField);
        }
    }

    // Method to demonstrate instance access
    void instanceMethod() {
        StaticNestedClass nested = new StaticNestedClass();
        nested.display();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the static nested class
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
        nestedObject.display();

        // Also, demonstrating instance method
        OuterClass outerObject = new OuterClass();
        outerObject.instanceMethod();

        // Printing Lab information
        System.out.println("\nQuestion No.: 9a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
