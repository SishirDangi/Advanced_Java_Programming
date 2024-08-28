// Base class
class Shape {
    // Method to calculate area
    public void calculateArea() {
        System.out.println("Calculating area for the shape.");
    }
}

// Subclass for Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Overriding method to calculate area of Rectangle
    @Override
    public void calculateArea() {
        double area = width * height;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Subclass for Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    // Constructor
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Overriding method to calculate area of Triangle
    @Override
    public void calculateArea() {
        double area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }
}

// Main class to demonstrate runtime polymorphism
class RuntimePolymorphism {
    public static void main(String[] args) {
        // Create objects of Rectangle and Triangle
        Shape rectangle = new Rectangle(5, 10);
        Shape triangle = new Triangle(4, 8);

        // Calculate areas
        rectangle.calculateArea(); // Calls Rectangle's calculateArea()
        triangle.calculateArea(); // Calls Triangle's calculateArea()

        // Printing Lab information
        System.out.println("\nQuestion No.: 8b");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
