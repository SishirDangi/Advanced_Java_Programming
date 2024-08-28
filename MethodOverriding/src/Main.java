// Superclass
class Animal {
    // Method to make a sound
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

// Subclass that overrides the makeSound method
class Dog extends Animal {
    // Overriding method
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

// Main class to demonstrate method overriding
class MethodOverriding {
    public static void main(String[] args) {
        // Creating an instance of Animal
        Animal animal = new Animal();
        animal.makeSound(); // Calls the method in Animal class

        // Creating an instance of Dog
        Dog dog = new Dog();
        dog.makeSound(); // Calls the overridden method in Dog class

        // Using a superclass reference to call the overridden method in Dog class
        Animal animalDog = new Dog();
        animalDog.makeSound(); // Calls the overridden method in Dog class

        // Printing Lab information
        System.out.println("\nQuestion No.: 8a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
