

public class ShipmentContext
{
    private Shipment shipment;
    private ShipmentState shipmentState;
    private boolean isFinished = false;

    public ShipmentContext(Shipment shipment) {
        this.shipment = shipment;
        shipmentState = new OrderReceived();
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

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
