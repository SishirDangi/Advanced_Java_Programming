class MethodOverloading {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();

        // Calling the overloaded methods
        System.out.println("Addition of two integers: " + mo.add(10, 20));
        System.out.println("Addition of three integers: " + mo.add(10, 20, 30));
        System.out.println("Addition of two doubles: " + mo.add(10.5, 20.5));

        // Printing Lab information
        System.out.println("\nQuestion No.: 4a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");

    }
}
