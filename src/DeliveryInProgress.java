import javax.xml.crypto.Data;
import java.util.ArrayList;
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



        ArrayList<Path> result_path = new ArrayList<>();
        ArrayList<Path> paths = Database.getInstance().getPaths();

        for(Path path : paths)
        {
            result_path.add(path);
            if (path.getToCity().equals(shipment.getCustomer().getLocation().getCityName()))
            {
                break;
            }
        }

        System.out.printf("Order#%s for '%s' now has status '%s'. Delivery Address is '%s' and Customer name is '%s'\n",
                shipment.getId(), shipment.getOrderedItem(), name(), shipment.getCustomer().getHomeAddress(),
                shipment.getCustomer().getName()
                );

        for (Path path : result_path)
        {
            System.out.printf("Order#%s is at location: %s\n", shipment.getId(),
                   path.getFromCity());
        }
        System.out.printf("Order#%s is at target location: %s\n", shipment.getId(),
                result_path.get(result_path.size() - 1).getToCity());


        double randomCustomerAtHomeChance = Math.random();

        if(randomCustomerAtHomeChance > 0.2){
            context.setShipmentState(new DeliverySuccessful());
        }else{
            context.setShipmentState(new DeliveryFailed());
        }
    }
}
