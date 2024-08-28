import java.util.Scanner;

// Base class Student
class Student {
    // Instance variable for roll number
    protected int roll_no;

    // Method to read roll number
    public void readRollNo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter roll number: ");
        roll_no = scanner.nextInt();
    }

    // Method to display roll number
    public void displayRollNo() {
        System.out.println("Roll Number: " + roll_no);
    }
}

// Derived class Test that inherits Student
class Test extends Student {
    // Instance variables for marks
    protected int marks1, marks2;

    // Method to read marks
    public void readMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks for subject 1: ");
        marks1 = scanner.nextInt();
        System.out.print("Enter marks for subject 2: ");
        marks2 = scanner.nextInt();
    }

    // Method to display marks
    public void displayMarks() {
        System.out.println("Marks in Subject 1: " + marks1);
        System.out.println("Marks in Subject 2: " + marks2);
    }
}

// Derived class Result that inherits Test
class Result extends Test {
    // Instance variable for total
    private int total;

    // Method to calculate total marks
    public void calculateTotal() {
        total = marks1 + marks2;
    }

    // Method to display total marks
    public void displayTotal() {
        System.out.println("Total Marks: " + total);
    }
}

// Main class to demonstrate inheritance
class InheritanceDemo {
    public static void main(String[] args) {
        // Creating an instance of Result class
        Result result = new Result();

        // Reading roll number
        result.readRollNo();
        // Reading marks
        result.readMarks();
        // Calculating total
        result.calculateTotal();

        // Displaying information
        result.displayRollNo();
        result.displayMarks();
        result.displayTotal();

        // Printing Lab information
        System.out.println("\nQuestion No.: 6");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
