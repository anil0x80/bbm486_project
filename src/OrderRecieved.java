public class OrderRecieved implements ShipmentState
{
    @Override
    public String name() {
        return null;
    }

    @Override
    public void processShipment(ShipmentContext context) {
        // eger customer'in yeterli parasi varsa -> CheckingStock
        // eger yoksa -> OrderFailed.
    }
}
