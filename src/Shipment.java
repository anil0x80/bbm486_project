
public class Shipment
{
    private int id;
    private String orderedItem;
    private float itemCost;
    private Customer customer;

    public float getItemCost() {
        return itemCost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shipment(int id, String orderedItem, Customer customer)
    {
        this.orderedItem = orderedItem;
        this.id = id;
        this.customer = customer;
        this.itemCost = Database.getInstance().getProductCost(orderedItem);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderedItem() {
        return orderedItem;
    }

    public void setOrderedItem(String orderedItem) {
        this.orderedItem = orderedItem;
    }

}

