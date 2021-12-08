public class ReadyToDelivery implements ShipmentState
{
    @Override
    public String name() {
        return "ReadyToDelivery";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        // bilgi printle
        // DeliveryInProgress
    }
}
