public class RoomPricing implements PricingComponent {

    private final int roomType;

    public RoomPricing(int roomType) {
        this.roomType = roomType;
    }
    @Override
    public Money monthly() {
        return switch (roomType) {
            case LegacyRoomTypes.SINGLE -> new Money(14000.0);
            case LegacyRoomTypes.DOUBLE -> new Money(15000.0);
            case LegacyRoomTypes.TRIPLE -> new Money(12000.0);
            default -> new Money(16000.0);
        };
    }
}