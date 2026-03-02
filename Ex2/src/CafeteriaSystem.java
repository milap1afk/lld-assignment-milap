import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceRepository store;
    private final PricingCalculator pricingCalculator;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private final InvoiceFormatter invoiceBuilder;

    private int invoiceSeq = 1000;

    public CafeteriaSystem() {
        this.store = new FileStore();
        this.pricingCalculator = new PricingCalculator();
        this.taxPolicy = new DefaultTaxPolicy();
        this.discountPolicy = new DefaultDiscountPolicy();
        this.invoiceBuilder = new InvoiceFormatter();
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {

        String invId = "INV-" + (++invoiceSeq);

        // 1. Calculate subtotal
        double subtotal = pricingCalculator.subtotal(menu, lines);

        // 2. Calculate tax
        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        // 3. Calculate discount
        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());

        // 4. Calculate total
        double total = subtotal + tax - discount;

        // 5. Build invoice text
        String invoiceText = invoiceBuilder.build(
                invId, menu, lines,
                subtotal, taxPct, tax,
                discount, total
        );

        // 6. Print
        System.out.print(invoiceText);

        // 7. Save
        store.save(invId, invoiceText);

        System.out.println("Saved invoice: " + invId +
                " (lines=" + store.countLines(invId) + ")");
    }
}