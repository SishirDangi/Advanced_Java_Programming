// Superclass
class SuperClass {
    // Constructor of SuperClass
    public SuperClass() {
        System.out.println("Constructor of SuperClass called.");
    }
}

// Subclass
class SubClass extends SuperClass {
    // Constructor of SubClass
    public SubClass() {
        // Calling the constructor of SuperClass
        super();
        System.out.println("Constructor of SubClass called.");
    }
}

// Main class to demonstrate the use of super keyword
class SuperKeywordDemo {
    public static void main(String[] args) {
        // Creating an instance of SubClass
        SubClass obj = new SubClass();

        // Printing Lab information
        System.out.println("\nQuestion No.: 7a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
