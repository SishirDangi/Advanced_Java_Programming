class StaticVariable {
    // Static variable
    static int count = 0;

    // Constructor to increment the static variable
    public StaticVariable() {
        count++;
    }

    public static void main(String[] args) {
        // Creating objects of the class
        StaticVariable obj1 = new StaticVariable();
        StaticVariable obj2 = new StaticVariable();
        StaticVariable obj3 = new StaticVariable();

        // Accessing the static variable
        System.out.println("Number of objects created: " + StaticVariable.count);

        // Printing Lab information
        System.out.println("\nQuestion No.: 5a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
