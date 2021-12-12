public class CheckingStock implements ShipmentState
{
    @Override
    public String name() {
        return "CheckingStock";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        String orderedItem = context.getShipment().getOrderedItem();
        int shipmentId = context.getShipment().getId();

        System.out.printf("Order#%s Checking stock!\n", shipmentId);

        if (Database.getInstance().isInStock(orderedItem))
        {
            System.out.printf("Order#%s Item %s is in stock!\n", shipmentId, orderedItem);
            boolean buyResult = Database.getInstance().buyProduct(context.getShipment().getCustomer(), orderedItem);
            assert(buyResult);
            context.setShipmentState(new Packaging());
        }
        else
        {
            context.setFailReason("Item: " + orderedItem + " is not in stock!");
            context.setShipmentState(new OrderFailed());
        }

    }
}
