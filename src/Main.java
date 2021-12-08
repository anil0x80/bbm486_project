import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Shipment shipment = new Shipment(1, "phone book", new Customer(56, "Emre",
                1000.f, "Ankara, Turkey" ));
        ShipmentContext context = new ShipmentContext(shipment);

        // Main loop
        //
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press enter to advance the state.");
        while(!context.isFinished())
        {
            int myint = keyboard.nextInt();

            context.processShipment();
        }

    }
}