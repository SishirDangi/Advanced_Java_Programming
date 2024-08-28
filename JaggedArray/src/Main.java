class JaggedArray {
    public static void main(String[] args) {
        // Creating a jagged array with different row sizes
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[3]; // 1st row has 3 columns
        jaggedArray[1] = new int[2]; // 2nd row has 2 columns
        jaggedArray[2] = new int[4]; // 3rd row has 4 columns

        // Initializing the jagged array
        int value = 1;
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = value++;
            }
        }

        // Displaying the jagged array
        System.out.println("The jagged array is:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }

        // Printing Lab information
        System.out.println("\nQuestion No.: 3c");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
