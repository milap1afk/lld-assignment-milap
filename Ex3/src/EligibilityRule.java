public interface EligibilityRule {
    void apply(StudentProfile s, RuleContext ctx);
}