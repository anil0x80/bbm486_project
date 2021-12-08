public class CheckingStock implements ShipmentState
{
    @Override
    public String name() {
        return "CheckingStock";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        // bilgi printle
        // shipment itemi database'deki stokda varsa -> Packaging
        // yoksa, -> OrderFailed
    }
}
