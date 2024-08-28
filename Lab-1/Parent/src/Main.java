// Superclass
class Parent {
    // Member variable
    String name = "Parent Name";

    // Method to display the name
    public void display() {
        System.out.println("Parent class name: " + name);
    }
}

// Subclass
class Child extends Parent {
    // Member variable (hides the variable in Parent)
    String name = "Child Name";

    // Method to display the name
    @Override
    public void display() {
        // Accessing the name variable from Parent class
        System.out.println("Child class name: " + name);
        System.out.println("Accessing Parent class name using super: " + super.name);
    }
}

// Main class to demonstrate the use of super keyword
class SuperKeywordDemo {
    public static void main(String[] args) {
        // Creating an instance of Child class
        Child obj = new Child();

        // Calling the display method
        obj.display();

        // Printing Lab information
        System.out.println("\nQuestion No.: 7b");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
