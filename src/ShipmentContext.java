

public class ShipmentContext
{
    private Shipment shipment;
    private ShipmentState shipmentState;

    public ShipmentContext(Shipment shipment)
    {
        this.shipment = shipment;
        //shipmentState = OrderRecieved;
    }

    public void processShipment()
    {
        shipmentState.processShipment(this);
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public ShipmentState getShipmentState() {
        return shipmentState;
    }

    public void setShipmentState(ShipmentState shipmentState) {
        this.shipmentState = shipmentState;
    }
}
