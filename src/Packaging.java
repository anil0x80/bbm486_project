public class Packaging implements ShipmentState
{
    @Override
    public String name() {
        return "Packaging";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        // bilgi printle
        // -> ReadyToDelivery
    }
}
