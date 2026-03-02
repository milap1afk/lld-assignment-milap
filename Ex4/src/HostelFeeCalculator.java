import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {

        List<PricingComponent> components = new ArrayList<>();

        // Room pricing component
        components.add(new RoomPricing(req.roomType));

        // Add-on pricing components
        for (AddOn a : req.addOns) {
            components.add(new AddOnPricing(a));
        }

        // Calculate monthly total
        Money monthly = new Money(0.0);
        for (PricingComponent c : components) {
            monthly = monthly.plus(c.monthly());
        }

        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

                
        Random r = new Random(1);
        String bookingId = "H-" + (7000 + r.nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }
}