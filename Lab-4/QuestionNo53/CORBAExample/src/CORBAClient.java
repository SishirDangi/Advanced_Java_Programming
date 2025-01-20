import CalculatorModule.Calculator;
import CalculatorModule.CalculatorHelper;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class CORBAClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            Calculator calculator = CalculatorHelper.narrow(ncRef.resolve_str("CalculatorService"));
            System.out.println("Addition: 8 + 12 = " + calculator.add(8, 12));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
