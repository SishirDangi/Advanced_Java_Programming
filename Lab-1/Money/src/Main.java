class Money {
    int rupee;
    int paisa;

    // Method to set the values of rupee and paisa
    void setMoney(int rupee, int paisa) {
        this.rupee = rupee;
        this.paisa = paisa;
    }

    // Method to display the values of rupee and paisa
    void displayMoney() {
        System.out.println(rupee + " Rupee, " + paisa + " Paisa");
    }

    // Method to add two Money objects and store the result in the current object
    void addMoney(Money m1, Money m2) {
        // Add paisa values and handle overflow into rupees
        this.paisa = m1.paisa + m2.paisa;
        this.rupee = m1.rupee + m2.rupee + this.paisa / 100;
        this.paisa = this.paisa % 100;
    }
}

class MoneyTest {
    public static void main(String[] args) {
        // Creating three Money objects
        Money m1 = new Money();
        Money m2 = new Money();
        Money m3 = new Money();

        // Setting values for the first two objects
        m1.setMoney(6, 90);
        m2.setMoney(9, 25);

        // Displaying the values of the first two objects
        System.out.print("First Money: ");
        m1.displayMoney();

        System.out.print("Second Money: ");
        m2.displayMoney();

        // Adding the first two objects and storing the result in the third object
        m3.addMoney(m1, m2);

        // Displaying the result of the addition
        System.out.print("Resultant Money after Addition: ");
        m3.displayMoney();

        // Printing Lab information
        System.out.println("\nQuestion No.: 2");
        System.out.println("Name: Sishir Dangi");
        System.out.println("Roll No.: 26740");
    }
}
