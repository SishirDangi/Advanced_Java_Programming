class MultipleCatch {
    public static void main(String[] args) {
        try {
            // Example 1: Divide by zero
            int result = 10 / 0;
            System.out.println("Result: " + result);

            // Example 2: Array index out of bounds
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing element at index 5: " + numbers[5]);

            // Example 3: Null pointer exception
            String text = null;
            System.out.println("Text length: " + text.length());

        } catch (ArithmeticException e) {
            // Catch block for arithmetic exceptions (e.g., divide by zero)
            System.out.println("ArithmeticException caught: " + e);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch block for array index out of bounds exceptions
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e);

        } catch (NullPointerException e) {
            // Catch block for null pointer exceptions
            System.out.println("NullPointerException caught: " + e);

        } catch (Exception e) {
            // Catch block for any other exceptions
            System.out.println("Exception caught: " + e);

        } finally {
            // Finally block that always executes
            System.out.println("Finally block executed.");
        }

        // Additional code after exception handling
        System.out.println("Program continues after try-catch-finally blocks.");

        System.out.println("\nQuestion No.: 12b");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
