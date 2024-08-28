class ExceptionHandling {
    public static void main(String[] args) {
        // Declare an array with 5 elements
        int[] numbers = {1, 2, 3, 4, 5};

        try {
            // Try to access an element outside the array bounds
            System.out.println("Accessing element at index 5: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch block to handle the exception
            System.out.println("Exception caught: " + e);
        } finally {
            // Finally block executes regardless of exception occurrence
            System.out.println("Finally block executed.");
        }

        // Additional code after exception handling
        System.out.println("Program continues after try-catch-finally blocks.");

        System.out.println("\nQuestion No.: 12a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
