public class OrderReceived implements ShipmentState
{
    @Override
    public String name() {
        return "OrderReceived";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        String product = context.getShipment().getOrderedItem();
        float price = context.getShipment().getItemCost();
        float customerMoney = context.getShipment().getCustomer().getMoney();
        System.out.println("The order has been received, checking if the customer has enough money.");
        System.out.println("Ordered item: " + product);

        context.setShipmentState(new CheckingStock());

        System.out.println("customerMoney: " + customerMoney);
        System.out.println("Price: " + price);
        if (price <= customerMoney)
        {
            context.setShipmentState(new CheckingStock());
        }
        else
        {
            System.out.println("Order failed because customer money: " + customerMoney + " is less than " +
                    "item price: " + price);
            context.setShipmentState(new OrderFailed());
        }

    }
}
