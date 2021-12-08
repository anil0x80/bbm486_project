public class DeliverySuccessful implements ShipmentState
{
    @Override
    public String name() {
        return "DeliverySuccessful";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        // bilgi printle
        context.setFinished(true);
    }
}
