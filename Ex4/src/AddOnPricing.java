public class AddOnPricing implements PricingComponent {

    private final AddOn addOn;

    public AddOnPricing(AddOn addOn) {
        this.addOn = addOn;
    }
    @Override
    public Money monthly() {
        return switch (addOn) {
            case MESS -> new Money(1000.0);
            case LAUNDRY -> new Money(500.0);
            case GYM -> new Money(300.0);
        };
    }
}