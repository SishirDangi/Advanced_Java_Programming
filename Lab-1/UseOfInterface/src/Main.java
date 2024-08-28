// Define the first interface
interface Animal {
    void eat();
}

// Define the second interface
interface Sound {
    void makeSound();
}

// A class that implements both interfaces
class Dog implements Animal, Sound {
    // Implementing methods from the Animal interface
    public void eat() {
        System.out.println("The dog is eating.");
    }

    // Implementing methods from the Sound interface
    public void makeSound() {
        System.out.println("The dog barks.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create an object of Dog
        Dog myDog = new Dog();

        // Call methods from Animal and Sound interfaces
        myDog.eat();
        myDog.makeSound();

        // Printing Lab information
        System.out.println("\nQuestion No.: 8d");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
