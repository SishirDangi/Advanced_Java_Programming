class ThrowKeyword {

    // Method to demonstrate the use of 'throw' keyword
    public static void checkAge(int age) {
        if (age < 18) {
            // Throwing an exception explicitly
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }

    public static void main(String[] args) {
        try {
            // Calling the method with a value that will cause an exception
            checkAge(15);
        } catch (ArithmeticException e) {
            // Catching the explicitly thrown exception
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            // Finally block to execute code regardless of exception
            System.out.println("Finally block executed.");
        }

        // Additional code after exception handling
        System.out.println("Program continues after throw-catch-finally blocks.");

        // Print the required details
        System.out.println("\nQuestion No.: 12d");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
