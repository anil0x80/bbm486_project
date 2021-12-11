import java.io.IOException;


public class Main
{
    // todo use these
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws IOException {
        Database.setCredentials(
            "jdbc:mysql://127.0.0.1:3306/bbm486_project?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
               "root", "ebN9rKK1");

        Shipment shipment = new Shipment(1, "iPhone 12",
                Database.getInstance().getCustomer(1));
        ShipmentContext context = new ShipmentContext(shipment);

        // Main loop
        //
        System.out.println( ANSI_RED + "Press enter to advance the state." + ANSI_RESET);
        while(!context.isFinished())
        {
            int value = System.in.read();

            context.processShipment();
        }

        Database.getInstance().close();
    }
}