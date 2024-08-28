// Abstract class
abstract class Animal {
    // Abstract method (does not have a body)
    abstract void makeSound();

    // Regular method
    void eat() {
        System.out.println("This animal eats food.");
    }
}

// Subclass (inherited from Animal)
class Dog extends Animal {
    // The body of makeSound() is provided here
    void makeSound() {
        System.out.println("The dog barks.");
    }
}

// Subclass (inherited from Animal)
class Cat extends Animal {
    // The body of makeSound() is provided here
    void makeSound() {
        System.out.println("The cat meows.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create objects of Dog and Cat
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        // Call the abstract method
        myDog.makeSound();
        myCat.makeSound();

        // Call the regular method
        myDog.eat();
        myCat.eat();

        // Printing Lab information
        System.out.println("\nQuestion No.: 8c");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
