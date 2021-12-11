public class Customer
{
    private int id;
    private String name;
    private float money;
    private Location homeAddress;

    public Customer(int id, String name, float money, Location homeAddress) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.homeAddress = homeAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getHomeAddress() {
        return this.homeAddress.getCityName()+" "+this.homeAddress.getDistrictName()+" "
                +this.homeAddress.getNeighborhoodName()+" "+this.homeAddress.getStreetName()+" No:"+this.homeAddress.getHomeNumber().toString();
    }

    public void setHomeAddress(Location homeAddress) {
        this.homeAddress = homeAddress;
    }
}
