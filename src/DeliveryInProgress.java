import java.util.concurrent.ThreadLocalRandom;

public class DeliveryInProgress implements ShipmentState
{
    @Override
    public String name() {
        return "DeliveryInProgress";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        Shipment shipment = context.getShipment();
        int randomWaitTime = ThreadLocalRandom.current().nextInt(1,6);

        for (int i = 0 ; i < randomWaitTime ; i++){
            System.out.printf("The order with the ID '%d' for '%s' now has status '%s'. Delivery Address is '%s' and Customer name is '%s'\n", shipment.getId(),
                    shipment.getOrderedItem(), name(), shipment.getCustomer().getHomeAddress(), shipment.getCustomer().getName());

        }


        double randomCustomerAtHomeChance = Math.random();

        if(randomCustomerAtHomeChance > 0.5){
            context.setShipmentState(new DeliverySuccessful());
        }else{
            context.setShipmentState(new DeliveryFailed());
        }

        // bilgi printle
        // eger customer evinde ise [probability?], DeliverySuccessful
        // eger degilse -> DeliveryFailed
    }
}
