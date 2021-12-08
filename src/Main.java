public class Main
{
    public static void main(String[] args)
    {
        Shipment shipment = new Shipment(1, "phone book", new Customer(56, "Emre",
                1000.f, "Ankara, Turkey" ));
        ShipmentContext context = new ShipmentContext(shipment);

        // Main loop
        //
    }
}