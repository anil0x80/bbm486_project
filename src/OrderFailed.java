public class OrderFailed implements ShipmentState
{
    @Override
    public String name() {
        return "OrderFailed";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        System.out.println("The order has been canceled.");
        System.out.println("Order details:");
        System.out.println("ID: " + context.getShipment().getId());
        System.out.println("Ordered item: " + context.getShipment().getOrderedItem());
        System.out.println("Customer: " + context.getShipment().getCustomer());
        // TODO System.out.println("Price: " + GetPrice );
        context.setFinished(true);
    }
}
