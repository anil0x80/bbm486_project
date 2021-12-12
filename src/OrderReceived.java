public class OrderReceived implements ShipmentState
{
    @Override
    public String name() {
        return "OrderReceived";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        String product = context.getShipment().getOrderedItem();
        int shipmentId = context.getShipment().getId();
        float price = context.getShipment().getItemCost();
        float customerMoney = context.getShipment().getCustomer().getMoney();
        System.out.printf("Order#%s has been received, checking if the customer has enough money.\n", shipmentId);
        System.out.printf("Order#%s item: %s \n",shipmentId, product);
        System.out.printf("Order#%s customerMoney: %.1f itemPrice: %.1f\n", shipmentId, customerMoney, price);

        if (price <= customerMoney)
        {
            context.setShipmentState(new CheckingStock());
        }
        else
        {
            context.setFailReason("Customer money: " + customerMoney + " is less that item price " + price);
            context.setShipmentState(new OrderFailed());
        }

    }
}
