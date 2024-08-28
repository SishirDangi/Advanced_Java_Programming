class LocalInnerClassDemo {

    // Method containing the local inner class
    public void display() {
        // Local inner class defined within the method
        class LocalInner {
            // Method of the local inner class
            void show() {
                System.out.println("This is a local inner class.");
            }
        }

        // Create an instance of the local inner class
        LocalInner localInner = new LocalInner();
        // Call the method of the local inner class
        localInner.show();
    }

    public static void main(String[] args) {
        // Create an instance of the outer class
        LocalInnerClassDemo demo = new LocalInnerClassDemo();
        // Call the method that contains the local inner class
        demo.display();
        // Printing Lab information
        System.out.println("\nQuestion No.: 9c");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
