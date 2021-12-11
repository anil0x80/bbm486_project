public class Location {

    private String cityName;
    private String districtName;
    private String neighborhoodName;
    private String streetName;
    private int homeNumber;


    public Location(String cityName, String districtName, String neighborhoodName, String streetName, int homeNumber) {
        this.cityName = cityName;
        this.districtName = districtName;
        this.neighborhoodName = neighborhoodName;
        this.streetName = streetName;
        this.homeNumber = homeNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }
}
