import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException {
        Database.setCredentials(
            "jdbc:mysql://127.0.0.1:3306/bbm486_project?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
               "root", "ebN9rKK1");

        Shipment shipment = new Shipment(1, "iPhone 12",
                Database.getInstance().getCustomer(0));
        ShipmentContext context = new ShipmentContext(shipment);

        // Main loop
        //
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press enter to advance the state.");
        while(!context.isFinished())
        {
            int value = System.in.read();

            context.processShipment();
        }

        Database.getInstance().close();
    }
}