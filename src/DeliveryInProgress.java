public class DeliveryInProgress implements ShipmentState
{
    @Override
    public String name() {
        return "DeliveryInProgress";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        // bilgi printle
        // eger customer evinde ise [probability?], DeliverySuccessful
        // eger degilse -> DeliveryFailed
    }
}
