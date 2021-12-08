public class OrderFailed implements ShipmentState
{
    @Override
    public String name() {
        return "OrderFailed";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        // fail mesaji yazdir
        context.setFinished(true);
    }
}
