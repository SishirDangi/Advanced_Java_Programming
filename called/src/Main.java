// Base class
class Animal {
    // Constructor of Animal
    public Animal() {
        System.out.println("Constructor of Animal called.");
    }
}

// Intermediate class (inherits Animal)
class Mammal extends Animal {
    // Constructor of Mammal
    public Mammal() {
        System.out.println("Constructor of Mammal called.");
    }
}

// Derived class (inherits Mammal)
class Dog extends Mammal {
    // Constructor of Dog
    public Dog() {
        System.out.println("Constructor of Dog called.");
    }
}

// Main class to demonstrate constructor calls in multilevel inheritance
class ConstructorCalled {
    public static void main(String[] args) {
        // Creating an instance of Dog class
        Dog dog = new Dog();

        // Printing Lab information
        System.out.println("\nQuestion No.: 7d");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
