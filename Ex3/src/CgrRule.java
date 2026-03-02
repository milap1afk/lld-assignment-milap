public class CgrRule implements EligibilityRule {
    @Override
    public void apply(StudentProfile s, RuleContext ctx) {
        if (s.cgr < 8.0) {
            ctx.fail("CGR below 8.0");
        }
    }
}