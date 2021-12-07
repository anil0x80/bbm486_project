public class Shipment
{
    private String id;
    private String orderedItem;
    private String deliveryAddress;

    public Shipment(String id, String orderedItem, String deliveryAddress)
    {
        this.orderedItem = orderedItem;
        this.id = id;
        this.deliveryAddress = deliveryAddress;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderedItem() {
        return orderedItem;
    }

    public void setOrderedItem(String orderedItem) {
        this.orderedItem = orderedItem;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}

