// Define a custom exception by extending Exception class
class InvalidAgeException extends Exception {
    // Constructor that accepts a custom error message
    public InvalidAgeException(String message) {
        super(message);
    }
}

class CustomExceptionDemo {

    // Method that throws the custom exception if the age is invalid
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throw the custom exception with a message
            throw new InvalidAgeException("Age is not valid for registration. Must be 18 or older.");
        } else {
            System.out.println("Age is valid for registration.");
        }
    }

    public static void main(String[] args) {
        try {
            // Test the custom exception with a valid and an invalid age
            checkAge(16); // This will throw the custom exception
            checkAge(20); // This will not throw the exception
        } catch (InvalidAgeException e) {
            // Catch and handle the custom exception
            System.out.println("Custom Exception caught: " + e.getMessage());
        } finally {
            // Finally block to execute code regardless of exception
            System.out.println("Finally block executed.");
        }

        // Additional code after exception handling
        System.out.println("Program continues after try-catch-finally blocks.");

        // Printing Lab information
        System.out.println("\nQuestion No.: 12f");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
