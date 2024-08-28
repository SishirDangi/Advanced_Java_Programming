class Box {
    // Variables to store dimensions of the box
    double length;
    double breadth;
    double height;

    // Constructor to initialize the variables
    Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    // Method to print the dimensions of the box
    void printDimensions() {
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Height: " + height);
    }

    // Method to calculate and print the volume of the box
    void printVolume() {
        double volume = length * breadth * height;
        System.out.println("Volume: " + volume);
    }

    // Main method to create objects and call methods
    public static void main(String[] args) {
        // Creating the first box object and initializing variables
        Box box1 = new Box(13, 9, 16);
        System.out.println("Box 1:");
        box1.printDimensions();
        box1.printVolume();

        // Creating the second box object and initializing variables
        Box box2 = new Box(9, 8, 4);
        System.out.println("\nBox 2:");
        box2.printDimensions();
        box2.printVolume();

        // Printing Lab information
        System.out.println("\nQuestion No.: 1");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
