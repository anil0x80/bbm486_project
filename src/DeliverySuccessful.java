public class DeliverySuccessful implements ShipmentState
{
    String DeliverySuccessfulNote="Order Package Handover to Customer";
    @Override
    public String name() {
        return "DeliverySuccessful";
    }

    @Override
    public void processShipment(ShipmentContext context) {

        System.out.printf("Order#'%s' for '%s' has status '%s (%s)'.\nDelivery Address is '%s'\n", context.getShipment().getId(),
                context.getShipment().getOrderedItem(), name(),DeliverySuccessfulNote
                , context.getShipment().getCustomer().getHomeAddress()
        );
        context.setFinished(true);
    }
}
