public class CheckingStock implements ShipmentState
{
    @Override
    public String name() {
        return "CheckingStock";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        String orderedItem = context.getShipment().getOrderedItem();

        System.out.println("Checking stock for the ordered item.");
        System.out.println("Ordered item: " + orderedItem);



        if (Database.getInstance().isInStock(orderedItem))
        {
            System.out.println("Item is in stock!");
            boolean buyResult = Database.getInstance().buyProduct(context.getShipment().getCustomer(), orderedItem);
            assert(buyResult);
            context.setShipmentState(new Packaging());
        }
        else
        {
            System.out.println("Order faiuled because item: " + orderedItem + " is not in stock!");
            context.setShipmentState(new OrderFailed());
        }



    }
}
