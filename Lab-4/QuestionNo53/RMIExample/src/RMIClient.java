import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Look up the remote object in the RMI registry
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            // Invoke remote methods
            System.out.println("Addition: 5 + 3 = " + calculator.add(5, 3));
            System.out.println("Subtraction: 10 - 4 = " + calculator.subtract(10, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
