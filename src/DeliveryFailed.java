public class DeliveryFailed implements ShipmentState
{
    String DeliveryFailedNote="Order Package Handover to Customer";
    @Override
    public String name() {
        return "DeliveryFailed";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        System.out.printf("Order#'%s' for '%s' has status '%s (%s)'.\nDelivery Address is '%s'\n", context.getShipment().getId(),
                context.getShipment().getOrderedItem(), name(),DeliveryFailedNote
                , context.getShipment().getCustomer().getHomeAddress()
        );
        context.setFinished(true);
    }
}
