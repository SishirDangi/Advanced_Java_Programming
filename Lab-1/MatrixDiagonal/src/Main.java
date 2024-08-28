import java.util.Scanner;
class MatrixDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];

        // Taking input for the 3x3 matrix
        System.out.println("Enter the elements of the 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Displaying the matrix
        System.out.println("The matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Displaying the diagonal elements
        System.out.println("Diagonal elements are:");
        for (int i = 0; i < 3; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        // Printing Lab information
        System.out.println("\nQuestion No.: 3b");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
