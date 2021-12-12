public class OrderFailed implements ShipmentState {
    @Override
    public String name() {
        return "OrderFailed";
    }

    @Override
    public void processShipment(ShipmentContext context) {
        System.out.printf("%sOrder#%s has failed! Reason: %s%s",ConsoleColors.ANSI_RED, context.getShipment().getId(),
                context.getFailReason(), ConsoleColors.ANSI_RESET);
        context.setFinished(true);
    }
}