class StaticBlockDemo {
    // Static variable
    static int value;

    // Static block
    static {
        value = 100;
        System.out.println("Static block executed. Value initialized to " + value);
    }

    public static void main(String[] args) {
        // Accessing the static variable
        System.out.println("Accessing the static variable: " + value);

        // Printing Lab information
        System.out.println("\nQuestion No.: 5c");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
