public class DeliveryFailed implements ShipmentState
{
    String DeliveryFailedNote="customer is not at home";
    @Override
    public String name() {
        return "DeliveryFailed";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        System.out.printf("Order#%s for '%s' has status '%s because (%s)!'.\n", context.getShipment().getId(),
                context.getShipment().getOrderedItem(), name(),DeliveryFailedNote
        );
        context.setFinished(true);
    }
}
