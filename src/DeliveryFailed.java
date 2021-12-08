public class DeliveryFailed implements ShipmentState
{
    @Override
    public String name() {
        return "DeliveryFailed";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        //bilgi printle
        context.setFinished(true);
    }
}
