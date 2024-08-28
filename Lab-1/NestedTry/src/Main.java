class NestedTry {
    public static void main(String[] args) {
        try {
            // Outer try block
            System.out.println("Outer try block begins.");

            // Example 1: Division by zero
            int result = 10 / 0; // This will cause ArithmeticException
            System.out.println("Result: " + result);

            try {
                // Inner try block
                System.out.println("Inner try block begins.");

                // Example 2: Array index out of bounds
                int[] numbers = {1, 2, 3};
                System.out.println("Accessing element at index 5: " + numbers[5]);

            } catch (ArrayIndexOutOfBoundsException e) {
                // Catch block for inner try
                System.out.println("ArrayIndexOutOfBoundsException caught: " + e);
            } finally {
                // Finally block for inner try
                System.out.println("Inner finally block executed.");
            }

        } catch (ArithmeticException e) {
            // Catch block for outer try
            System.out.println("ArithmeticException caught: " + e);
        } finally {
            // Finally block for outer try
            System.out.println("Outer finally block executed.");
        }

        // Additional code after exception handling
        System.out.println("Program continues after nested try-catch-finally blocks.");

        // Print the required details
        System.out.println("\nQuestion No.: 12c");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
