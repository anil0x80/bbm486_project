public class ReadyToDelivery implements ShipmentState
{

    public ReadyToDelivery() {
        super();
    }

    @Override
    public String name() {
        return "ReadyToDelivery";
    }

    @Override
    public void processShipment(ShipmentContext context) {

        Shipment shipment = context.getShipment();
        System.out.printf("The order with the ID '%d' for '%s' now has status '%s'. Delivery Address is '%s' and Customer name is '%s'\n", shipment.getId(),
                shipment.getOrderedItem(), name(), shipment.getCustomer().getHomeAddress(), shipment.getCustomer().getName());


        context.setShipmentState(new DeliveryInProgress());


        // bilgi printle
        // DeliveryInProgress


    }
}
