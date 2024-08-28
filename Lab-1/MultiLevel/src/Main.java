// Base class
class Animal {
    // Method to display type of animal
    public void displayAnimal() {
        System.out.println("This is an Animal.");
    }
}

// Intermediate class (inherits Animal)
class Mammal extends Animal {
    // Method to display characteristics of mammal
    public void displayMammal() {
        System.out.println("This is a Mammal.");
    }
}

// Derived class (inherits Mammal)
class Dog extends Mammal {
    // Method to display specific type of dog
    public void displayDog() {
        System.out.println("This is a Dog.");
    }
}

// Main class to demonstrate multilevel inheritance
class MultilevelInheritance {
    public static void main(String[] args) {
        // Creating an instance of Dog class
        Dog dog = new Dog();

        // Calling methods from each level of inheritance
        dog.displayAnimal();  // From Animal class
        dog.displayMammal();  // From Mammal class
        dog.displayDog();     // From Dog class

        // Printing Lab information
        System.out.println("\nQuestion No.: 7c");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
