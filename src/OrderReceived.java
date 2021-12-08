public class OrderReceived implements ShipmentState
{
    @Override
    public String name() {
        return "OrderReceived";
    }

    @Override
    public void processShipment(ShipmentContext context) {

        System.out.println("The order has been received, checking if the customer has enough money.");
        System.out.println("Ordered item: " + context.getShipment().getOrderedItem());

        /* TODO
        System.out.println("Price: " + GetPrice );
        if (GetPrice <= GetCustomerMoney)
            context.setShipmentState(new CheckingStock())
        else
            context.setShipmentState(new OrderFailed())
         */
    }
}
