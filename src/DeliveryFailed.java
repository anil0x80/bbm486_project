public class DeliveryFailed implements ShipmentState
{
    String DeliveryFailedNote="customer is not at home";
    @Override
    public String name() {
        return "DeliveryFailed";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        System.out.printf("%sOrder#%s for '%s' has status '%s because (%s)!'. %s\n",
                ConsoleColors.ANSI_RED,context.getShipment().getId(),
                context.getShipment().getOrderedItem(), name(),DeliveryFailedNote, ConsoleColors.ANSI_RESET
        );
        context.setFinished(true);
    }
}
