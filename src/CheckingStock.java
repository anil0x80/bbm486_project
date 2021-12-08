public class CheckingStock implements ShipmentState
{
    @Override
    public String name() {
        return "CheckingStock";
    }

    @Override
    public void processShipment(ShipmentContext context) {

        System.out.println("Checking stock for the ordered item.");
        System.out.println("Ordered item: " + context.getShipment().getOrderedItem());

        /* TODO
        if (IsStock)
            context.setShipmentState(new Packaging())
        else
            context.setShipmentState(new OrderFailed())
         */

    }
}
