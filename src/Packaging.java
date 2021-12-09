public class Packaging implements ShipmentState
{
    @Override
    public String name() {
        return "Packaging";
    }

    @Override
    public void processShipment(ShipmentContext context) {

        Shipment shipment = context.getShipment();

        System.out.printf("Order#%s for '%s' now has status '%s'. Delivery Address is '%s' and Customer name is '%s'\n", shipment.getId(),
                shipment.getOrderedItem(), name(), shipment.getCustomer().getHomeAddress(), shipment.getCustomer().getName());

        context.setShipmentState(new ReadyToDelivery());
    }
}
