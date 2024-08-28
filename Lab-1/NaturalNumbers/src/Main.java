class NaturalNumbers {
    public static void main(String[] args) {
        // Creating an array to store the first 15 natural numbers
        int[] numbers = new int[15];

        // Initializing the array with the first 15 natural numbers
        for (int i = 0; i < 15; i++) {
            numbers[i] = i + 1;
        }

        // Calculating the sum of the 3rd (index 2) and the last (index 14) elements
        int sum = numbers[2] + numbers[14];

        // Displaying the sum
        System.out.println("The sum of the 3rd and last element is: " + sum);

        // Printing Lab information
        System.out.println("\nQuestion No.: 3a");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
