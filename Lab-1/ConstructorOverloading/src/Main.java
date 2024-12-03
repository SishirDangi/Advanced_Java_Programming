class ConstructorOverloading {
    int id;
    String name;
    int age;

    // Constructor with no parameters
    public ConstructorOverloading() {
        id = 0;
        name = "Unknown";
        age = 0;
    }

    // Constructor with two parameters
    public ConstructorOverloading(int id, String name) {
        this.id = id;
        this.name = name;
        this.age = 0;
    }

    // Constructor with three parameters
    public ConstructorOverloading(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Method to display the details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // Creating objects using different constructors
        ConstructorOverloading obj1 = new ConstructorOverloading();
        ConstructorOverloading obj2 = new ConstructorOverloading(1, "Sishir");
        ConstructorOverloading obj3 = new ConstructorOverloading(2, "Bibek", 25);

        // Displaying the details of each object
        obj1.display();
        obj2.display();
        obj3.display();

        // Printing Lab information
        System.out.println("\nQuestion No.: 4b");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
