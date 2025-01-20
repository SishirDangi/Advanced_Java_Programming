import CalculatorModule.CalculatorPOA;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class CalculatorImpl extends CalculatorPOA {
    public long add(long a, long b) {
        return a + b;
    }
}

public class CORBAServer {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            CalculatorImpl calculator = new CalculatorImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(calculator);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            ncRef.rebind(ncRef.to_name("CalculatorService"), ref);

            System.out.println("CORBA Server running...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
