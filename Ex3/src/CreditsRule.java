public class CreditsRule implements EligibilityRule {
    @Override
    public void apply(StudentProfile s, RuleContext ctx) {
        if (s.earnedCredits < 20) {
            ctx.fail("credits below 20");
        }
    }
}