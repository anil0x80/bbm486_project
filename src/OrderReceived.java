public class OrderReceived implements ShipmentState
{
    @Override
    public String name() {
        return "OrderReceived";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        // bilgi printle
        // eger customer'in yeterli parasi varsa -> CheckingStock
        // eger yoksa -> OrderFailed.
    }
}
