// Define the Shape interface
interface Shape {
    double area(double x, double y);
    double perimeter(double x, double y);
}

// Implement the Rectangle class that implements the Shape interface
class Rectangle implements Shape {
    // Instance variables for the dimensions of the rectangle
    private double length;
    private double width;

    // Constructor to initialize the length and width
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implement the area method
    @Override
    public double area(double length, double width) {
        return length * width;
    }

    // Implement the perimeter method
    @Override
    public double perimeter(double length, double width) {
        return 2 * (length + width);
    }
}

// Main class to demonstrate interface implementation
class InterfaceDemo {
    public static void main(String[] args) {
        // Create an instance of Rectangle
        Rectangle rect = new Rectangle(5.0, 3.0);

        // Compute and display the area and perimeter
        double area = rect.area(5.0, 3.0);
        double perimeter = rect.perimeter(5.0, 3.0);

        // Output the results
        System.out.println("Area of the rectangle: " + area);
        System.out.println("Perimeter of the rectangle: " + perimeter);

        System.out.println("\nQuestion No.: 11");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
